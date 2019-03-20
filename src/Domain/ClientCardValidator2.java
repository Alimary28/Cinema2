package Domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ClientCardValidator2 implements IValidator<ClientCard2>{

    public void validate2(ClientCard2 clientCard2) {

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        try {
            format.parse(clientCard2.getBirthDate());
        } catch (ParseException pe) {
            throw new RuntimeException("The date of birth is not in a correct format!");
        }

        try {
            format.parse(clientCard2.getRegistrationDate());
        } catch (ParseException pe) {
            throw new RuntimeException("The date of registration is not in a correct format!");
        }
    }
    public void validateCnp(ClientCard2 clientCard2){
        if((clientCard2.getCnp()).length() < 9 || (clientCard2.getCnp()).length() >9){
            throw new RuntimeException("Invalid CNP!");
        }
    }

}
