package com.example.project.service.impl;

import com.example.project.model.entity.Landmark;
import com.example.project.model.entity.Town;
import com.example.project.repository.LandmarkRepository;
import com.example.project.service.LandmarkService;
import com.example.project.service.TownService;
import org.springframework.stereotype.Service;

@Service
public class LandMarkServiceImpl implements LandmarkService {
    private final LandmarkRepository landmarkRepository;
    private final TownService townService;

    public LandMarkServiceImpl(LandmarkRepository landmarkRepository, TownService townService) {
        this.landmarkRepository = landmarkRepository;
        this.townService = townService;
    }

    @Override
    public void initialiseLandmarks() {
        if (landmarkRepository.count()==0){
            Town sofia = townService.findByName("Sofia");
            Landmark nevski = new Landmark("Saint Alexander of Neva Patriarch's Cathedral", "https://res.cloudinary.com/ivoto22/image/upload/v1635681712/aleksandarnevski_pionzm.jpg", sofia);
            nevski.setDescription("The St. Alexander Nevsky Cathedral is a Bulgarian Orthodox cathedral in Sofia, the capital of Bulgaria. Built in Neo-Byzantine style, it serves as the cathedral church of the Patriarch of Bulgaria and it is believed to be one of the 50 largest Christian church buildings by volume in the world. It is one of Sofia's symbols and primary tourist attractions. The St. Alexander Nevsky Cathedral in Sofia occupies an area of 3,170 square metres and can hold 5,000 people inside. It is believed to be among the 10 largest Eastern Orthodox church buildings. It is the largest completed Orthodox Cathedral located in Southeast Europe. It is believed that until year 2000 it was the largest finished Orthodox Cathedral.");
            landmarkRepository.save(nevski);
            Landmark palaceofculture = new Landmark("National Palace of Culture", "https://res.cloudinary.com/ivoto22/image/upload/v1635682153/licensed-image_y0977m.jpg", sofia);
            palaceofculture.setDescription("The National Palace of Culture, located in Sofia, the capital of Bulgaria, is the largest, multifunctional conference and exhibition centre in south-eastern Europe. It was opened in 1981 in celebration of Bulgaria's 1300th anniversary. The centre was initiated at the suggestion of Lyudmila Zhivkova, daughter of the communist leader of the former People's Republic of Bulgaria Todor Zhivkov. The project was designed by a team of Bulgarian and foreign architects led by Alexander Georgiev Barov along with Ivan Kanazirev. The landscaping of Bulgaria Square in front of the National Palace of Culture was designed by another team of architects and landscape engineers, led by Atanas Agura. Internally, the building exhibits a unified style, employing an octagonal motif and heavy, dark colours. Large bright murals depicting historical figures and events cover the main wall of many of the smaller halls. During the 1990s, immediately following the change of the political model in the country, the NDK lost a significant portion of its property, including infrastructure, commercial areas, and car parks.");
            landmarkRepository.save(palaceofculture);
            Landmark borisgardner = new Landmark("Boris' Garden Park", "https://res.cloudinary.com/ivoto22/image/upload/v1635682286/licensed-image_1_z9wl5j.jpg", sofia);
            borisgardner.setDescription("Borisova gradina or Knyaz-Borisova gradina is the oldest and best known park in Sofia, the capital of Bulgaria. Its construction and arrangement began in 1884 and it is named after Bulgarian Tsar Boris III. The history of the garden embraces three periods under three renowned gardeners. All followed the initial scheme, developing it further and perfecting it instead of making radical changes to the original design");
            Town belgrade = townService.findByName("Belgrade");
            Landmark belgradefortress = new Landmark("Belgrade Fortress", "https://res.cloudinary.com/ivoto22/image/upload/v1635682472/licensed-image_2_mk0jjd.jpg", belgrade);
            belgradefortress.setDescription("The Belgrade Fortress, consists of the old citadel and Kalemegdan Park on the confluence of the Sava and Danube rivers, in an urban area of modern Belgrade, Serbia. It is located in Belgrade's municipality of Stari Grad. Belgrade Fortress was declared a Monument of Culture of Exceptional Importance in 1979, and is protected by the Republic of Serbia. It is the most visited tourist attraction in Belgrade, with Skadarlija being the second. Since the admission is free, it is estimated that the total number of visitors is over 2 million yearly.");
            landmarkRepository.save(belgradefortress);
            Landmark aeronauticalmuseum = new Landmark("Aeronautical Museum", "https://res.cloudinary.com/ivoto22/image/upload/v1635682835/images_nfjbra.jpg", belgrade);
            aeronauticalmuseum.setDescription("The Aeronautical Museum Belgrade, formerly known as the Yugoslav Aeronautical Museum, is a museum located in Surčin, Belgrade, the capital of Serbia. Founded in 1957, the museum is located adjacent to Belgrade Nikola Tesla Airport. The current facility, designed by architect Ivan Štraus, was opened to the public on 21 May 1989");
            landmarkRepository.save(aeronauticalmuseum);
            Landmark noveupalasis = new Landmark("Nouveau Palais", "https://res.cloudinary.com/ivoto22/image/upload/v1635683047/2021-05-27_x0hfmx.jpg", belgrade);
            noveupalasis.setDescription("The New Palace was a royal residence of the Karađorđević dynasty of Serbia and later Kingdom of Yugoslavia. Today it is the seat of the President of Serbia. The palace is located on Andrićev Venac in Belgrade, Serbia, opposite of Stari Dvor.");
            landmarkRepository.save(noveupalasis);
            Town dubrovnik = townService.findByName("Dubrovnik");
            Landmark cablecar = new Landmark("Dubrovnik Cable Car", "https://res.cloudinary.com/ivoto22/image/upload/v1635683384/images_1_hmovam.jpg", dubrovnik);
            cablecar.setDescription("Scenic hillside ride for views & dining");
            landmarkRepository.save(cablecar);
            Landmark gameofthronestour = new Landmark("Game Of Thrones Tour", "https://res.cloudinary.com/ivoto22/image/upload/v1635683575/Game-of-Thrones-Tour-Dubrovnik_zab8el.jpg", dubrovnik);
            gameofthronestour.setDescription("Walk past landmarks from the fictional Westeros on a Game of Thrones filming locations tour.");
            landmarkRepository.save(gameofthronestour);
            Landmark stradun = new Landmark("Stradun", "https://res.cloudinary.com/ivoto22/image/upload/v1635683689/images_2_a8qm9j.jpg", dubrovnik);
            stradun.setDescription("Stradun or Placa is the main street of Dubrovnik, Croatia. The limestone-paved pedestrian street runs some 300 metres through the Old Town, the historic part of the city surrounded by the Walls of Dubrovnik. The site of the present-day street used to be a marshy channel which separated Ragusa from the forest settlement of Dubrava before it was reclaimed in the 13th century. Stradun stretches through the walled town in the east-west direction, connecting the western entrance called the \"Pile Gate\" to the \"Ploče Gate\" on the eastern end. Both ends are also marked with 15th-century fountains and bell towers. Stradun became the city's main thoroughfare in the 13th century, and its current appearance was for the most part created following the devastating 1667 earthquake in which most of the buildings in Ragusa were destroyed. Before the earthquake the houses which line the street were not so uniformly designed as they appear today, with many of them featuring arcades and elaborate decorations.");
            landmarkRepository.save(stradun);
            Town zagreb = townService.findByName("Zagreb");
            Landmark cathedralofzagreb = new Landmark("Cathedral of Zagreb", "https://res.cloudinary.com/ivoto22/image/upload/v1635683825/images_3_dtjely.jpg", zagreb);
            cathedralofzagreb.setDescription("Zagreb Cathedral, on the Kaptol, is a Roman Catholic cathedral-church and not only the second tallest building in Croatia but also the most monumental sacral building in Gothic style southeast of the Alps. It is dedicated to the Assumption of Mary and to kings Saint Stephen and Saint Ladislaus. The cathedral is typically Gothic, as is its sacristy, which is of great architectural value. Its prominent spires are considered to be landmarks as they are visible from most parts of the city. One of its two spires was damaged in an earthquake that took place on March 22nd, 2020.");
            landmarkRepository.save(cathedralofzagreb);
            Landmark medvednica = new Landmark("Medvednica", "https://res.cloudinary.com/ivoto22/image/upload/v1635684006/licensed-image_3_xu2ehc.jpg", zagreb);
            medvednica.setDescription("Medvednica is a mountain in central Croatia, just north of Zagreb, and marking the southern border of the historic region of Zagorje. The highest peak, at 1,035 m is Sljeme. Most of the area of Medvednica is a nature park, a type of preservation lesser than a national park. The area of the park is 228.26 km² and about 63% is covered with forest. During Miocene and Pliocene, the mountain was an island within the Pannonian Sea. ");
            landmarkRepository.save(medvednica);
            Town ljubljana = townService.findByName("Ljubljana");
            Landmark dragonbridge = new Landmark("Dragon Bridge", "https://res.cloudinary.com/ivoto22/image/upload/v1635684226/licensed-image_4_mdcyk2.jpg", ljubljana);
            dragonbridge.setDescription("The Dragon Bridge is a road bridge located in Ljubljana, the capital of Slovenia. It crosses the Ljubljanica River. between Kopitar Street and Ressel Street, to the north of the Ljubljana Central Market at Vodnik Square. It was built in the beginning of the 20th century, when Ljubljana was part of the Austro-Hungarian Empire. As one of the best examples of reinforced concrete bridges and of the Vienna Secession style, the bridge is today protected as a technical monument. It is intended primarily for motorised traffic.");
            landmarkRepository.save(dragonbridge);
            Landmark ljubljanacastle = new Landmark("Ljubljana Castle", "https://res.cloudinary.com/ivoto22/image/upload/v1635684331/licensed-image_5_nqfqnh.jpg", ljubljana);
            ljubljanacastle.setDescription("Ljubljana Castle is a castle complex standing on Castle Hill above downtown Ljubljana, the capital of Slovenia. It is a key landmark of the town. Originally a medieval fortress, it was probably constructed in the 11th century and rebuilt in the 12th century. It acquired its present outline with an almost complete overhaul in the 15th century, whereas the majority of the buildings date to the 16th and 17th centuries. Initially a defense structure and since the first half of the 14th century the seat of the lords of Carniola, it was since the early 19th century used for various other purposes and today is used as a major cultural venue. The castle is depicted on the city's coat of arms, along with a dragon on top.");
            landmarkRepository.save(ljubljanacastle);
            Town rome = townService.findByName("Rome");
            Landmark colloseum = new Landmark("Colosseum", "https://res.cloudinary.com/ivoto22/image/upload/v1635684459/images_4_rdvkxp.jpg", rome);
            colloseum.setDescription("The Colosseum is an oval amphitheatre in the centre of the city of Rome, Italy, just east of the Roman Forum. It is the largest ancient amphitheatre ever built, and is still the largest standing amphitheatre in the world today, despite its age. Construction began under the emperor Vespasian in 72 and was completed in 80 AD under his successor and heir, Titus. Further modifications were made during the reign of Domitian. The three emperors that were patrons of the work are known as the Flavian dynasty, and the amphitheatre was named the Flavian Amphitheatre by later classicists and archaeologists for its association with their family name. The Colosseum is built of travertine limestone, tuff, and brick-faced concrete. The Colosseum could hold an estimated 50,000 to 80,000 spectators at various points in its history having an average audience of some 65,000; it was used for gladiatorial contests and public spectacles including animal hunts, executions, re-enactments of famous battles, and dramas based on Roman mythology, and briefly mock sea battles. The building ceased to be used for entertainment in the early medieval era.");
            landmarkRepository.save(colloseum);
            Landmark trevifountain = new Landmark("Trevi Fountain", "https://res.cloudinary.com/ivoto22/image/upload/v1635684545/images_5_zkmxot.jpg", rome);
            trevifountain.setDescription("The Trevi Fountain is a fountain in the Trevi district in Rome, Italy, designed by Italian architect Nicola Salvi and completed by Giuseppe Pannini and several others. Standing 26.3 metres high and 49.15 metres wide, it is the largest Baroque fountain in the city and one of the most famous fountains in the world. The fountain has appeared in several films, including Roman Holiday, the eponymous Three Coins in the Fountain, Federico Fellini's classic La Dolce Vita, The Lizzie McGuire Movie, and Sabrina Goes to Rome.");
            landmarkRepository.save(trevifountain);
            Landmark romancforum = new Landmark("Roman Forum","https://res.cloudinary.com/ivoto22/image/upload/v1635684636/images_6_mj1qak.jpg", rome);
            romancforum.setDescription("The Roman Forum, also known by its Latin name Forum Romanum, is a rectangular forum surrounded by the ruins of several important ancient government buildings at the center of the city of Rome. Citizens of the ancient city referred to this space, originally a marketplace, as the Forum Magnum, or simply the Forum. For centuries the Forum was the center of day-to-day life in Rome: the site of triumphal processions and elections; the venue for public speeches, criminal trials, and gladiatorial matches; and the nucleus of commercial affairs. Here statues and monuments commemorated the city's great men. The teeming heart of ancient Rome, it has been called the most celebrated meeting place in the world, and in all history. Located in the small valley between the Palatine and Capitoline Hills, the Forum today is a sprawling ruin of architectural fragments and intermittent archaeological excavations attracting 4.5 million or more sightseers yearly. Many of the oldest and most important structures of the ancient city were located on or near the Forum. The Roman Kingdom's earliest shrines and temples were located on the southeastern edge.");
            landmarkRepository.save(romancforum);
            Landmark spanishsteps = new Landmark("Spanish Steps","https://res.cloudinary.com/ivoto22/image/upload/v1635684708/images_7_apoqar.jpg", rome);
            spanishsteps.setDescription("The Spanish Steps are a set of steps in Rome, Italy, climbing a steep slope between the Piazza di Spagna at the base and Piazza Trinità dei Monti, dominated by the Trinità dei Monti church at the top. The monumental stairway of 135 steps was built with French diplomat Étienne Gueffier's bequeathed funds of 20,000 scudi, in 1723–1725, linking the Trinità dei Monti church that was under the patronage of the Bourbon kings of France and the Bourbon Spanish Embassy at the top of the steps to the Holy See in the Palazzo Monaldeschi at the bottom of the steps. The stairway was designed by architects Francesco de Sanctis and Alessandro Specchi.");
            landmarkRepository.save(spanishsteps);
            Town florence = townService.findByName("Florentia");
            Landmark basillica = new Landmark("Basilica of Santa Croce", "https://res.cloudinary.com/ivoto22/image/upload/v1635684842/licensed-image_6_bhuls5.jpg", florence);
            basillica.setDescription("The Basilica di Santa Croce is the principal Franciscan church in Florence, Italy, and a minor basilica of the Roman Catholic Church. It is situated on the Piazza di Santa Croce, about 800 meters south-east of the Duomo. The site, when first chosen, was in marshland outside the city walls. It is the burial place of some of the most illustrious Italians, such as Michelangelo, Galileo, Machiavelli, the poet Foscolo, the philosopher Gentile and the composer Rossini, thus it is known also as the Temple of the Italian Glories.");
            landmarkRepository.save(basillica);
            Landmark uffizigallery = new Landmark("Uffizi Gallery", "https://res.cloudinary.com/ivoto22/image/upload/v1635684919/images_8_n55sxe.jpg", florence);
            uffizigallery.setDescription("The Uffizi Gallery is a prominent art museum located adjacent to the Piazza della Signoria in the Historic Centre of Florence in the region of Tuscany, Italy. One of the most important Italian museums and the most visited, it is also one of the largest and best known in the world and holds a collection of priceless works, particularly from the period of the Italian Renaissance. After the ruling House of Medici died out, their art collections were given to the city of Florence under the famous Patto di famiglia negotiated by Anna Maria Luisa, the last Medici heiress. The Uffizi is one of the first modern museums. The gallery had been open to visitors by request since the sixteenth century, and in 1765 it was officially opened to the public, formally becoming a museum in 1865.");
            landmarkRepository.save(uffizigallery);
            Town milano = townService.findByName("Milano");
            Landmark duomo_di_milano = new Landmark("Duomo di Milano", "https://res.cloudinary.com/ivoto22/image/upload/v1635685164/images_9_fzcrsy.jpg", milano);
            duomo_di_milano.setDescription("The Milan Cathedral, or Metropolitan Cathedral-Basilica of the Nativity of Saint Mary, is the cathedral church of Milan, Lombardy, Italy. Dedicated to the Nativity of St Mary, it is the seat of the Archbishop of Milan, currently Archbishop Mario Delpini. The cathedral took nearly six centuries to complete: construction began in 1386, and the final details were completed in 1965. It is the largest church in Italy—the larger St. Peter's Basilica is in the State of Vatican City, a sovereign state—and the second largest in Europe and the third largest in the world.");
            landmarkRepository.save(duomo_di_milano);
            Landmark galleriaemanuelle = new Landmark("Galleria Vittorio Emanuele II", "https://res.cloudinary.com/ivoto22/image/upload/v1635685234/images_10_ljyncs.jpg", milano);
            galleriaemanuelle.setDescription("The Galleria Vittorio Emanuele II is Italy's oldest active shopping gallery and a major landmark of Milan in Italy. Housed within a four-story double arcade in the centre of town, the Galleria is named after Victor Emmanuel II, the first king of the Kingdom of Italy. It was designed in 1861 and built by architect Giuseppe Mengoni between 1865 and 1877.");
            landmarkRepository.save(galleriaemanuelle);
            Town sanmarino = townService.findByName("San Marino");
            Landmark guaitatower = new Landmark("Guaita Tower", "https://res.cloudinary.com/ivoto22/image/upload/v1635685368/images_11_l4nrwp.jpg", sanmarino);
            guaitatower.setDescription("Guaita is one of three peaks which overlooks the city of San Marino, the capital of San Marino. The other two are De La Fratta and Montale.");
            landmarkRepository.save(guaitatower);




        }

    }
}
