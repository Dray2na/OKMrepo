package sonok.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;

import sonok.global.guiMenuNode;
import sonok.gui.GUI_LogIn;
import sonok.gui.GUI_Menu;
import sonok.gui.GUI_Menu_Entry;
import sonok.gui.GUI_Wiki;
import sonok.gui.GUI_Wiki_Edit;
	
public class Main {
	public static ContentManager Manager;
	public static MainFrame Frame;
	public static GUI_Menu Menu;
	public static GUI_LogIn LogIn;
	
	public static void main(String[] args) {
//		Programmstart
		Init();
	}
	
	private static void Init() {
//		Hier werden die Hauptobjekte erstellt
			Manager = new ContentManager();
			Frame = new MainFrame();
			Menu = new GUI_Menu();
			//LogIn = new GUI_LogIn();
		
//		Menü im Frame anhängen, MainFrame verwaltet das Menü und die Panels
		Frame.setMenu(Menu);
		
//		Lest euch bitte mal die Funktion durch
		makeMenu_Mit_Kommentaren();
//		Danach könnt ihr die benutzen
		//makeMenu();
	}
	
	private static void makeMenu_Mit_Kommentaren() {
//	Hier wird die Verwendung des Menüs erklärt
//	Lest euch die Kommentare am besten mal durch
//		
//	Später müssen diese Einträge durch den Content Manager erstellt werden.
//
//	Für einen Menüeintrag verwendet GUI_Menu_Entry
//	Die Klasse wird wird prinzipiell so erstellt:
//		new GUI_Menu_Entry( Text, Icon / Bild, Größe / GrößeOffen, ClickEvent )
//		
//		Es gibt zahlreiche Konstruktoren, sodass
//		ihr schon beim Erstellen einige Entscheidungen
//		über das Design treffen könnt.
//		
//	Zum einfügen von Menüeinträgen  in das Hauptmenü
//	verwendet Menu.addEntry( GUI_Menu_Entry )
//			
//	Hier wird der Kopf erstellt
//		Zuerst ein 10 Pixel hoher, Oranger Balken.
		Menu.addEntry(new GUI_Menu_Entry(10)).setBackground(new Color(255, 128, 0));
		
//		Der Header bekommt eine Beschriftung, kein Icon, aber einen Hintergrund,
//		wenn ihr den Konstruktor so benutzt, wird das Bild über die ganze Fläche gestreckt.
		GUI_Menu_Entry header = Menu.addEntry(new GUI_Menu_Entry("sonok", "", "wallpaper", 40, null));
//			Um sie weiter zu bearbeiten kann man
//			Menüpunkte in eine Variable ablegen.
			header.setForeground(Color.WHITE);
			
//		Der nächste Eintrag hat ein Icon. Die liegen alle in "Sonok/data/icon/"
//		Ich habe Icons aus einem alten Projekt genommen, wir können ja noch eigene machen	
//			Außerdem hat dieses Icon keinen Rand
//			Hier wäre ein kleines Profilbild nice
		Menu.addEntry(new GUI_Menu_Entry("Mister Mustermann", "user", null)).setMargin(0);
		
//		Hier wird ein kleiner Scrolltext erstellt. Das geschieht automatisch, wenn der Text zu lang ist.
		GUI_Menu_Entry ticker = Menu.addEntry(new GUI_Menu_Entry("3 Neue Nachricht/en - 1 Neue Aufgabe/n - 4 Neue Rolle/n - Der Ofen ist noch an!", 24, null));
			ticker.setBackground(Color.BLACK);
			ticker.setForeground(Color.YELLOW);
			
//		Beim Erstellen eines ausklappbaren Menüeintrages können 
//		so zum aufstylen zwei Größen angegeben werden.
//		Die Größe ändert sich dann beim Ausklappen.
//			
//		Um später Childs hinzufügen muss der Eintrag wieder in einer Variable abgelegt werden.
		GUI_Menu_Entry freunde = Menu.addEntry(new GUI_Menu_Entry("Freunde", "up", 32, 24, null));

//			Childknoten hinzufügen per Menu.addEntryChild(parend, child);
//			Hier werden ein paar User angelegt
			Menu.addEntryChild(freunde, new GUI_Menu_Entry("User 1", "offline", 28, null));		
			Menu.addEntryChild(freunde, new GUI_Menu_Entry("User 2", "offline", 28, null));

//			User 3 kann man Ausklappen
			final guiMenuNode user3 = Menu.addEntryChild(freunde, new GUI_Menu_Entry("User 3", "user", 28, 32,null));
				Menu.addEntryChild(user3, new GUI_Menu_Entry("", "", "user", 192, null));	
				Menu.addEntryChild(user3, new GUI_Menu_Entry("Nachricht", "note", 32, null));
				Menu.addEntryChild(user3, new GUI_Menu_Entry("Daten", "db", 32, null));	
				Menu.addEntryChild(user3, new GUI_Menu_Entry("Aufgaben", "project", 32, null));	
		
			Menu.addEntryChild(freunde, new GUI_Menu_Entry("User 4", "offline", 28, null));
		
//		Hier noch ein Beispiel: Klickt man hier auf den Parentknoten, werden
//		im Thread die Childs geöffnet, so können Panels aneinander gehängt werden.
		final GUI_Menu_Entry news = Menu.addEntry(new GUI_Menu_Entry("News", "edit", 32, 24, null));
			final GUI_Menu_Entry line1 = Menu.addEntryChild(news, new GUI_Menu_Entry("Der Bürgermeister wurde heute zum dritten mal vom OK gefilmt. Ihm wurden dabei Blumen überreicht.","Edit",24,null));
			final GUI_Menu_Entry line2 = Menu.addEntryChild(news, new GUI_Menu_Entry("Berichte berichten, dass es auf der Welt immer mehr Ausländer gibt. Vorallem im Ausland!","Edit",24,null));
			final GUI_Menu_Entry line3 = Menu.addEntryChild(news, new GUI_Menu_Entry("Lol, CSC ist pleite :'D amuggi, die Opfer! Soll jetzt gekauft werden von denen, die den Namen ASAP gekauft haben; Awesome Solutions for Awesome Problems!","Prio",24,null));
			final GUI_Menu_Entry line4 = Menu.addEntryChild(news, new GUI_Menu_Entry("Weitere Meteoritenschauer über Frankfurt, München und Mainz","Edit",24,null));
			news.setOnClickEvent(new Thread(){
				@Override
				public void run() {
					super.run();
					if (!news.isOpen()) {
						Frame.addPanel(new GUI_LogIn(),line1);
						Frame.addPanel(new GUI_Wiki_Edit(),line2);
						Frame.addPanel(new GUI_LogIn(),line3);
						Frame.addPanel(new GUI_LogIn(),line4);
					} else {
						Frame.removePanel(line1);
						Frame.removePanel(line2);
						Frame.removePanel(line3);
						Frame.removePanel(line4);
					}
				}
			});
			
		//Weitere beispieleinträge
		GUI_Menu_Entry wiki = Menu.addEntry(new GUI_Menu_Entry("Wiki", "book", null));
		GUI_Menu_Entry nachrichten = Menu.addEntry(new GUI_Menu_Entry("Nachrichten", "note", null));
		GUI_Menu_Entry aufgaben = Menu.addEntry(new GUI_Menu_Entry("Projekte", "project", null));
			Menu.addEntryChild(aufgaben, new GUI_Menu_Entry("Bürgermeister der Film", "task", null));
			Menu.addEntryChild(aufgaben, new GUI_Menu_Entry("Filmprojektfindung", "prio", null));
			Menu.addEntryChild(aufgaben, new GUI_Menu_Entry("Nichtstun", "task", null));
			Menu.addEntryChild(aufgaben, new GUI_Menu_Entry("Granatapfelmanagement", "task", null));
			Menu.addEntryChild(aufgaben, new GUI_Menu_Entry("Ente Ente Ente Ente Ente Ente Ente", "prio", null));

//			Einstellungen
			final GUI_Menu_Entry settings = Menu.addEntry(new GUI_Menu_Entry("Einstellungen", "settings", null));	
			
//				So kann man einem Menüpunkt eine Funktion hinzufügen
				Menu.addEntryChild(settings,new GUI_Menu_Entry("Panel+", 24, new Thread(){
					@Override
					public void run() {
//						Dieser Menüeintrag fügt ein Panel in das Frame ein
//						So könnt ihr eure Panels im Programm testen
						Frame.addPanel(new GUI_LogIn(),settings);
					}
				})).setMargin(0);
				
				Menu.addEntryChild(settings,new GUI_Menu_Entry("Panel-", 24, new Thread(){
					@Override
					public void run() {
//						Diese Funktion ist Global und schließt alle Panels
						Frame.clearPanels();
					}
				})).setMargin(0);		
//			Programm beenden button
			Menu.addEntry(new GUI_Menu_Entry("Schließen", "close", new Thread(){
				@Override
				public void run() {
					System.exit(0);
				}
			})).setMargin(0);

		//Menüfuß
		Menu.addEntry(new GUI_Menu_Entry(10)).setBackground(new Color(255, 128, 0));
//		Den Hintergrund kann man auch noch ändern ^^
		//Frame.setBackground(Color.BLACK);
		Menu.setBackground(new Color(255,255,128));
//		Zum schluss noch das Frame refreshen, damit alle änderungen sichtbar sind!
		Frame.Refresh();
	}
	
	
	
	
	private static void makeMenu() {
//		Am besten lasst die kommentierte version da, und baut hier euer eigenes Menü,
//		dann könnt ihr das ein oder andere vielleicht nochmal nachlesen oder kopieren. :)
		
		Menu.addEntry(new GUI_Menu_Entry(10)).setBackground(new Color(255, 128, 0));
		GUI_Menu_Entry header = Menu.addEntry(new GUI_Menu_Entry("OKM Menü", 40, null));
			header.setBackground(Color.LIGHT_GRAY);
			header.setForeground(Color.WHITE);
			
		Menu.addEntry(new GUI_Menu_Entry("Mister Mustermann", "user", 28, null)).setMargin(10);
		
		GUI_Menu_Entry freunde = Menu.addEntry(new GUI_Menu_Entry("Freunde", "up", 32, 24, null));
			Menu.addEntryChild(freunde, new GUI_Menu_Entry("User 1", "offline", 28, null));		
			Menu.addEntryChild(freunde, new GUI_Menu_Entry("User 2", "offline", 28, null));
			GUI_Menu_Entry user3 = Menu.addEntryChild(freunde, new GUI_Menu_Entry("User 3", "user", 28, 32,null));
				Menu.addEntryChild(user3, new GUI_Menu_Entry("", "", "user", 160, null));	
				Menu.addEntryChild(user3, new GUI_Menu_Entry("Nachricht", "note", 32, null));
				Menu.addEntryChild(user3, new GUI_Menu_Entry("Daten", "db", 32, null));	
				Menu.addEntryChild(user3, new GUI_Menu_Entry("Aufgaben", "project", 32, null));	
		
			Menu.addEntryChild(freunde, new GUI_Menu_Entry("User 4", "offline", 28, null));
		GUI_Menu_Entry news = Menu.addEntry(new GUI_Menu_Entry("News", "Edit", 32, 24, null));
			Menu.addEntryChild(news, new GUI_Menu_Entry("Der Bürgermeister wurde heute zum dritten mal vom OK gefilmt. Ihm wurden dabei Blumen überreicht.","Edit",null));
			Menu.addEntryChild(news, new GUI_Menu_Entry("Berichte berichten, dass es auf der Welt immer mehr Ausländer gibt. Vorallem im Ausland!","Edit",null));
			Menu.addEntryChild(news, new GUI_Menu_Entry("Weitere Meteoritenschauer über Frankfurt, München und Mainz","Edit",null));

			Menu.addEntry(new GUI_Menu_Entry("Panel+", "open", 32, new Thread(){
				@Override
				public void run() {
					Frame.addPanel(new GUI_LogIn()).setBackground(Color.DARK_GRAY);
				}
			})).setMargin(0);
			Menu.addEntry(new GUI_Menu_Entry("Panel-", "delete", 32, new Thread(){
				@Override
				public void run() {
					Frame.clearPanels();
				}
			})).setMargin(0);	
			Menu.addEntry(new GUI_Menu_Entry("Schließen", "close", new Thread(){
				@Override
				public void run() {
					System.exit(0);
				}
			})).setMargin(0);

		Menu.addEntry(new GUI_Menu_Entry(10)).setBackground(new Color(255, 128, 0));
		
		Frame.Refresh();
	}
}
