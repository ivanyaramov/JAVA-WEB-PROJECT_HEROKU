package com.example.project.service.impl;

import com.example.project.model.binding.ChangePasswordBindingModel;
import com.example.project.model.binding.RoleBindingModel;
import com.example.project.model.binding.UserProfileBindingModel;
import com.example.project.model.binding.UserRegisterBindingModel;
import com.example.project.model.comparator.BookingExcursionComparator;
import com.example.project.model.comparator.BookingHotelComparator;
import com.example.project.model.entity.UserEntity;
import com.example.project.model.entity.UserRoleEntity;
import com.example.project.model.entity.UserRoleEnum;
import com.example.project.model.service.ChangePasswordServiceModel;
import com.example.project.model.service.UserProfileServiceModel;
import com.example.project.model.service.UserRegisterServiceModel;
import com.example.project.model.view.BookingExcursionViewModel;
import com.example.project.model.view.BookingHotelViewModel;
import com.example.project.model.view.UserEntityViewModel;
import com.example.project.repository.UserRepository;
import com.example.project.service.HotelService;
import com.example.project.service.UserRoleService;
import com.example.project.service.UserService;
import com.example.project.web.NoAccessException;
import com.example.project.web.ObjectNotFoundException;
import com.example.project.web.UserNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRoleService userRoleService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ProjectUserServiceImpl projectUserService;
    private final ModelMapper modelMapper;
    private final HotelService hotelService;

    public UserServiceImpl(UserRoleService userRoleService, UserRepository userRepository, PasswordEncoder passwordEncoder, ProjectUserServiceImpl projectUserService, ModelMapper modelMapper, HotelService hotelService) {
        this.userRoleService = userRoleService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.projectUserService = projectUserService;
        this.modelMapper = modelMapper;
        this.hotelService = hotelService;
    }


    public boolean isUserNameFree(String username) {
        return userRepository.findByUsernameIgnoreCase(username).isEmpty();
    }

    @Override
    public void registerAndLoginUser(UserRegisterServiceModel userRegistrationServiceModel) {

        UserRoleEntity userRole = userRoleService.findByRole(UserRoleEnum.USER);
        Set<UserRoleEntity> set = Set.of(userRole);

        UserEntity newUser = modelMapper.map(userRegistrationServiceModel, UserEntity.class);

//        newUser.setUsername(userRegistrationServiceModel.getUsername());
//        newUser.setFullName(userRegistrationServiceModel.getFullName());
            newUser.setActive(false);
                newUser.setPassword(passwordEncoder.encode(userRegistrationServiceModel.getPassword()));
               newUser.setRoles(Set.of(userRole));

        newUser = userRepository.save(newUser);

        // this is the Spring representation of a user
        UserDetails principal = projectUserService.loadUserByUsername(newUser.getUsername());
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                principal,
                newUser.getPassword(),
                principal.getAuthorities()
        );

        SecurityContextHolder.
                getContext().
                setAuthentication(authentication);
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(()-> new UserNotFoundException(username, "users"));
    }

    @Override
    public boolean isEmailFree(String email) {
        return  userRepository.getByEmail(email).isEmpty();
    }

    @Override
    public void initaliseUsers() {
        if(userRepository.count()==0) {
            UserRoleEntity user = userRoleService.findByRole(UserRoleEnum.USER);
            UserRoleEntity mod = userRoleService.findByRole(UserRoleEnum.MODERATOR);
            UserRoleEntity admin = userRoleService.findByRole(UserRoleEnum.ADMIN);
            UserEntity gosho = new UserEntity();
            gosho.setFullName("Ivan Yaramov");
            gosho.setPassword(passwordEncoder.encode("12345"));
            gosho.setUsername("gosho");
            gosho.setAge(20);
            gosho.setEmail("absbs@gmail.com");
            gosho.setTelephoneNum("08987874568");
            gosho.setRoles(Set.of(user));
            UserEntity moderator = new UserEntity();
            moderator.setFullName("Moderator Moderatorov");
            moderator.setPassword(passwordEncoder.encode("12345"));
            moderator.setUsername("moder");
            moderator.setAge(21);
            moderator.setEmail("abs34bs@gmail.com");
            moderator.setTelephoneNum("08947874568");
            moderator.setRoles(Set.of(user, mod));
            UserEntity adminentity = new UserEntity();
            adminentity.setFullName("Admin Adminov");
            adminentity.setPassword(passwordEncoder.encode("12345"));
            adminentity.setUsername("admin");
            adminentity.setAge(22);
            adminentity.setEmail("abs52534bs@gmail.com");
            adminentity.setTelephoneNum("08947814568");
            adminentity.setRoles(Set.of(user, mod, admin));
            userRepository.save(gosho);
            userRepository.save(moderator);
            userRepository.save(adminentity);
        }
    }

    @Override
    public UserEntity findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<BookingExcursionViewModel> getAllExcursionBookings(String username) {
        UserEntity user = findByUsername(username);
    List<BookingExcursionViewModel> list =  user.getBookingExcursions().stream()
                .map(b-> {
                    BookingExcursionViewModel bookingExcursionViewModel = modelMapper.map(b, BookingExcursionViewModel.class);
bookingExcursionViewModel.setExcursion(b.getExcursion().getName());
return bookingExcursionViewModel;
                }).
                     collect(Collectors.toList());

        Collections.sort(list,new BookingExcursionComparator());
        return list;
    }

    @Override
    public List<BookingHotelViewModel> getAllHotelBookings(String username) {
        UserEntity userEntity = findByUsername(username);
        List<BookingHotelViewModel> list = userEntity.getBookingHotels().stream()
                .map(b->{
                    BookingHotelViewModel bookingHotelViewModel = modelMapper.map(b, BookingHotelViewModel.class);
                    bookingHotelViewModel.setHotel(b.getHotel().getName());
                    bookingHotelViewModel.setTown(b.getHotel().getTown().getName());
                    bookingHotelViewModel.setPrice(hotelService.priceOfHotelBooking(b.getNights(), BigDecimal.valueOf(b.getCountOfChildren()), BigDecimal.valueOf(b.getCountOfAdults()),b.getHotel().getId()));
                    return bookingHotelViewModel;
                }).collect(Collectors.toList());
        Collections.sort(list,new BookingHotelComparator());
return list;
    }

    @Override
    public List<UserEntityViewModel> getAllUsersView() {
        return getAllUsers().stream()
                .map(u-> {
                    UserEntityViewModel userEntityViewModel = modelMapper.map(u, UserEntityViewModel.class);
                    List<String> list = u.getRoles().stream().map(r->r.getRole().toString()).collect(Collectors.toList());
                    userEntityViewModel.setRoles(String.join(", ", list));
                    return userEntityViewModel;
                } ).collect(Collectors.toList());
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void addRole(Long userid, RoleBindingModel roleBindingModel) {
        UserEntity user = findById(userid);
        UserRoleEntity userRoleEntity = userRoleService.findByRole(roleBindingModel.getUserRoleEnum());
             user.getRoles().add(userRoleEntity);
        userRepository.save(user);

    }

    @Override
    public void removeRole(Long userid, RoleBindingModel roleBindingModel) {
        UserEntity user = findById(userid);
        UserRoleEntity userRoleEntity = userRoleService.findByRole(roleBindingModel.getUserRoleEnum());
        if(!userRoleEntity.getRole().toString().equals("USER")){
            user.getRoles().remove(userRoleEntity);
            userRepository.save(user);
        }
    }

    @Override
    public UserProfileBindingModel mapUserToBindingModel(String username) {
        return modelMapper.map(findByUsername(username),UserProfileBindingModel.class);
    }

    @Override
    public void throwExceptionIfUsernameDoesNotExist(String username) {
        findByUsername(username);
    }

    @Override
    public boolean canAccess(String usernameOfCaller, String usernameOfModified) {
        throwExceptionIfUsernameDoesNotExist(usernameOfCaller);
        throwExceptionIfUsernameDoesNotExist(usernameOfModified);
        if(!usernameOfCaller.equals(usernameOfModified)){
            throw new NoAccessException();
        }
        return true;
    }

    @Override
    public void editUser(String username, UserProfileServiceModel userProfileServiceModel) {
        UserEntity user = findByUsername(username);
        user.setEmail(userProfileServiceModel.getEmail());
        user.setAge(userProfileServiceModel.getAge());
        user.setTelephoneNum(userProfileServiceModel.getTelephoneNum());
        user.setFullName(userProfileServiceModel.getFullName());
        userRepository.save(user);

    }

    @Override
    public boolean isPasswordCorrect(String username, ChangePasswordServiceModel changePasswordServiceModel) {
        UserEntity user = findByUsername(username);

        return passwordEncoder.matches(changePasswordServiceModel.getOldPassword(), user.getPassword());
    }

    @Override
    public void changePassword(String username, ChangePasswordServiceModel changePasswordServiceModel) {
        UserEntity user = findByUsername(username);
        user.setPassword(passwordEncoder.encode(changePasswordServiceModel.getNewPassword()));
        userRepository.save(user);
    }
}
