package br.com.safeline.modules.user.exception;

public class UsernameNotFoundException extends RuntimeException {
    public UsernameNotFoundException() {
        super("email not found");
    }

}