package sonok.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;

import sonok.global.guiMenuNode;
import sonok.gui.GUI_LogIn;
import sonok.gui.GUI_Menu;
import sonok.gui.GUI_Menu_Entry;
	
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
		
//		Men� im Frame anh�ngen, MainFrame verwaltet das Men� und die Panels
		Frame.setMenu(Menu);
		
//		Lest euch bitte mal die Funktion durch
		makeMenu_Mit_Kommentaren();
//		Danach k�nnt ihr diese Benutzen:
		//makeMenu();
	}
	
	private static void makeMenu_Mit_Kommentaren() {
//	Hier wird die Verwendung des Men�s erkl�rt
//	Lest euch die Kommentare am besten mal durch
//		
//	Sp�ter m�ssen diese Eintr�ge durch den Content Manager erstellt werden.
//
//	F�r einen Men�eintrag verwendet GUI_Menu_Entry
//	Die Klasse wird wird prinzipiell so erstellt:
//		new GUI_Menu_Entry( Text, Icon / Bild, Gr��e / Gr��eOffen, ClickEvent )
//		
//		Es gibt zahlreiche Konstruktoren, sodass
//		ihr schon beim Erstellen einige Entscheidungen
//		�ber das Design treffen k�nnt.
//		
//	Zum einf�gen von Men�eintr�gen  in das Hauptmen�
//	verwendet Menu.addEntry( GUI_Menu_Entry )
//			
//	Hier wird der Kopf erstellt
//		Zuerst ein 10 Pixel hoher, Oranger Balken.
		Menu.addEntry(new GUI_Menu_Entry(10)).setBackground(new Color(255, 128, 0));
		
//		Der Header bekommt eine Beschriftung, kein Icon, aber einen Hintergrund,
//		wenn ihr den Konstruktor so benutzt, wird das Bild �ber die ganze Fl�che gestreckt.
		GUI_Menu_Entry header = Menu.addEntry(new GUI_Menu_Entry("sonok", "", "wallpaper", 40, null));
//			Um sie weiter zu bearbeiten kann man
//			Men�punkte in eine Variable ablegen.
			header.setForeground(Color.WHITE);
			
//		Der n�chste Eintrag hat ein Icon. Die liegen alle in "Sonok/data/icon/"
//		Ich habe Icons aus einem alten Projekt genommen, wir k�nnen ja noch eigene machen	
//			Au�erdem hat dieses Icon keinen Rand
//			Hier w�re ein kleines Profilbild nice
		Menu.addEntry(new GUI_Menu_Entry("Mister Mustermann", "user", null)).setMargin(0);
		
		
		//Weitere beispieleintr�ge
		GUI_Menu_Entry wiki = Menu.addEntry(new GUI_Menu_Entry("Wiki", "book", null));
		GUI_Menu_Entry nachrichten = Menu.addEntry(new GUI_Menu_Entry("Nachrichten", "note", null));
		GUI_Menu_Entry aufgaben = Menu.addEntry(new GUI_Menu_Entry("Projekte", "project", null));
			Menu.addEntryChild(aufgaben, new GUI_Menu_Entry("B�rgermeister der Film", "task", null));
			Menu.addEntryChild(aufgaben, new GUI_Menu_Entry("Filmprojektfindung", "prio", null));
			Menu.addEntryChild(aufgaben, new GUI_Menu_Entry("Nichtstun", "task", null));
			Menu.addEntryChild(aufgaben, new GUI_Menu_Entry("Granatapfelmanagement", "task", null));
			Menu.addEntryChild(aufgaben, new GUI_Menu_Entry("Ente Ente Ente Ente Ente Ente Ente", "prio", null));

//			Einstellungen
			final GUI_Menu_Entry settings = Menu.addEntry(new GUI_Menu_Entry("Einstellungen", "settings", null));	
			
//				So kann man einem Men�punkt eine Funktion hinzuf�gen
				Menu.addEntryChild(settings,new GUI_Menu_Entry("Panel+", 24, new Thread(){
					@Override
					public void run() {
//						Dieser Men�eintrag f�gt ein Panel in das Frame ein
//						So k�nnt ihr eure Panels im Programm testen
						Frame.addPanel(new GUI_LogIn(),settings);
					}
				})).setMargin(0);
				
				Menu.addEntryChild(settings,new GUI_Menu_Entry("Panel-", 24, new Thread(){
					@Override
					public void run() {
//						Diese Funktion ist Global und schlie�t alle Panels
						Frame.clearPanels();
					}
				})).setMargin(0);		
//			Programm beenden button
			Menu.addEntry(new GUI_Menu_Entry("Schlie�en", "close", new Thread(){
				@Override
				public void run() {
					System.exit(0);
				}
			})).setMargin(0);
	}
}
