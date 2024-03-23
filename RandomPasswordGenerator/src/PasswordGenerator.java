import java.util.Random;

public class PasswordGenerator {
	public static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
	public static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String NUMBERS = "0123456789";
	public static final String SPECIAL_SYMBOLS = "!@#$%^&*()_-+={}[];:,.<>/?";
	
	private final Random random;
	
	public PasswordGenerator(){
		random = new Random();
	}
	
	public String generatePassword(int length, boolean includeLowercase, boolean includeUppercase,
									boolean includeNumbers, boolean includeSymbols) {
		
		StringBuilder passwordBuilder = new StringBuilder();
		
		String validCharacters = "";
		
		if(includeLowercase) {
			validCharacters += LOWERCASE_CHARACTERS;
		}
		if(includeUppercase) {
			validCharacters += UPPERCASE_CHARACTERS;
		}
		if(includeNumbers) {
			validCharacters += NUMBERS;
		}
		if(includeSymbols) {
			validCharacters += SPECIAL_SYMBOLS;
		}
		
		for(int i = 0; i<=length; i++) {
			
			int randomIndex = random.nextInt(validCharacters.length());
			
			char randomChar = validCharacters.charAt(randomIndex);
			
			passwordBuilder.append(randomChar);
		}
		
		return passwordBuilder.toString();
	}
}
