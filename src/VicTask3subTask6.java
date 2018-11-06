import java.io.ByteArrayOutputStream;
import java.io.IOException;
/*6. Генератор паролей
Реализуй логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов.
2) только цифры и латинские буквы разного регистра.
3) обязательно должны присутствовать цифры, и буквы разного регистра.
Все сгенерированные пароли должны быть уникальные.
Пример правильного пароля:
wMh7smNu*/
public class VicTask3subTask6 {
	// https://www.tutorialspoint.com/java/java_bytearrayoutputstream.htm
	// https://ru.stackoverflow.com/questions/533675/%D0%A0%D0%B5%D0%B3%D1%83%D0%BB%D1%8F%D1%80%D0%BD%D0%BE%D0%B5-%D0%B2%D1%8B%D1%80%D0%B0%D0%B6%D0%B5%D0%BD%D0%B8%D0%B5-%D0%B4%D0%BB%D1%8F-%D0%BF%D0%B0%D1%80%D0%BE%D0%BB%D1%8F-%D0%BE%D1%82-6-%D1%81%D0%B8%D0%BC%D0%B2%D0%BE%D0%BB%D0%BE%D0%B2-%D1%81-%D0%B8%D1%81%D0%BF%D0%BE%D0%BB%D1%8C%D0%B7%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5%D0%BC-%D1%86%D0%B8%D1%84%D1%80-%D1%81%D0%BF%D0%B5%D1%86-%D1%81%D0%B8%D0%BC%D0%B2%D0%BE/533681
	// https://www.quora.com/How-do-I-write-a-regex-for-a-string-that-contains-alphanumeric-characters-having-at-least-one-uppercase-letter-one-lowercase-letter-and-one-digit
	

	public static void main(String[] args) throws IOException
	{
		PasswordTool.lenghtPassword = 8;
		for (int i = 0; i < 15; i++)
		{
			ByteArrayOutputStream baos = PasswordTool.getPassword();
			System.out.println("Is '" +baos.toString() + "' a valid ?  = " + PasswordTool.validatePassword(baos.toString()));
			
		}
		//Для теста
		//	String str = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{1,})";
		String str = "((?=.*\\d)(?=.*[a-z])).{1,}";
		System.out.println("3f".matches(str));
		System.out.println("3f3".matches(str));
	
	}
		
}
