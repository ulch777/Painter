import java.util.Locale;
import java.util.ResourceBundle;


public class PainterMain 
{
	public static Locale currentLocale;
	public static ResourceBundle messages;

	public static void main(String[] args) 
	{
		String language;
		String country;

		if (args.length !=2)
		{
			language  = new String("ru");
			country  = new String("RU");
		}
		else
		{
			language  = new String(args[0]);
			country  = new String(args[1]);
		}

		currentLocale  = new Locale(language, country);
		messages = ResourceBundle.getBundle("MessageBundle", currentLocale);
		new PaintFrame();
	}
}
