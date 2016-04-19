import com.alee.laf.WebLookAndFeel;
import com.alee.managers.notification.NotificationIcon;
import com.alee.managers.notification.NotificationManager;
import com.alee.managers.notification.WebNotificationPopup;
import com.tn.cinema.controller.MainController;

public class MallaCinemaLauncher {

	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				WebLookAndFeel.install();
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
		
		WebLookAndFeel.install();
		MainController mainController=new MainController();
		mainController.startTheApp();
		
		
	}

}
