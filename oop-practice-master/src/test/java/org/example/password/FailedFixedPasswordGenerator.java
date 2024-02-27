package org.example.password;

import org.example.password.PasswordGenerator;

public class FailedFixedPasswordGenerator implements PasswordGenerator {

    @Override
    public String generatePassword() {
        return "wrong";
    }
}
