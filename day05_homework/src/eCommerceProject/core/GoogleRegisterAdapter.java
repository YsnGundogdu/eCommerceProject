package eCommerceProject.core;

import eCommerceProject.Google.GoogleRegister;

public class GoogleRegisterAdapter implements GoogleService{
    @Override
    public void registerToSystem(String message) {
        GoogleRegister googleRegister = new GoogleRegister();
        googleRegister.send(message);
    }
}
