

package exceptions;


public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException() {
    }
    public ResourceNotFoundException(String e) {
        super(e);
    }
}
