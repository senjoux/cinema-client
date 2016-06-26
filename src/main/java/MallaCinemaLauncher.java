import com.alee.laf.WebLookAndFeel;
import com.tn.cinema.controller.MainController;

public class MallaCinemaLauncher {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		
		WebLookAndFeel.install();
		MainController mainController=new MainController();
		mainController.startTheApp();
		
		
	}

}
