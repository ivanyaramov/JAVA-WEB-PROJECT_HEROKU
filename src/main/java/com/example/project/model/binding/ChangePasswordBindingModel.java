package com.example.project.model.binding;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ChangePasswordBindingModel {
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;

@NotNull
@Size(min = 4)
    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }
    @NotNull
    @Size(min = 4)
    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
    @NotNull
    @Size(min = 4)
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
