package sonok.content;

import java.util.ArrayList;
import sonok.global.func;

public class ContentManager {
	
	public class Content {
		private Page_Base page;
		private ArrayList<String> keywords = new ArrayList<String>();
		
		public Content(Page_Base p, ArrayList<String> kw) {
			page = p;
			
			if (kw != null) {
				keywords = kw;
			}
		}

		public boolean addKeyword(String e) {
			return keywords.add(e);
		}

		public void clearKeywords() {
			keywords.clear();
		}

		public boolean contains(Object o) {			
			for (int i = 0; i < keywords.size(); i++) {
				if (keywords.get(i).equals(o)) {
					return true;
				}
			}
			
			return false;
		}
		
	}

	private ArrayList<Content> contents = new ArrayList<Content>();

	public boolean add(Content e) {
		return contents.add(e);
	}

	public void clear() {
		contents.clear();
	}

	public Content get(int index) {
		return contents.get(index);
	}

	public int indexOf(Object o) {
		return contents.indexOf(o);
	}

	public Content remove(int index) {
		return contents.remove(index);
	}

	public boolean remove(Object o) {
		return contents.remove(o);
	}

	public Content set(int index, Content element) {
		return contents.set(index, element);
	}

	public int size() {
		return contents.size();
	}
	
	public ArrayList<Content> Search(ArrayList<String> words) {
		ArrayList<Content> result = new ArrayList<Content>();
		
		for (int i = 0; i < contents.size(); i++)
		for (int k = 0; k < words.size(); k++) 
		{			
			if (contents.get(i).contains(words.get(k))) {
				result.add(contents.get(i));
			}
		}
		
		return result;		
	}
	
	public ArrayList<Content> Search(String s) {
		ArrayList<String> words = func.SplitLines(s,',');
		
		return Search(words);		
	}	
	
}
