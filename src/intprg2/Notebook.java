package intprg2;

import java.util.ArrayList;

public class Notebook {
	private int curPage;
	private ArrayList<Page> pages;
	
	public Notebook(int n)
	{
		curPage = 0;
		pages = new ArrayList<Page>();
		int i;
		for(i = 0; i < n; i++)
		{
			Page page = new Page(i+1);
			pages.add(page);
		}
	}
	
	public void writeOnCurrentPage(String str)
	{
		pages.get(curPage).write(str);
	}
	
	public String retrieveCurrentPage()
	{
		return pages.get(curPage).getContent();
	}
	
	public void flipFwd()
	{
		if (curPage + 1 < pages.size())
		{
			curPage++;
		}
	}
	
	public void flipBkwd()
	{
		if (curPage - 1 >= 0)
		{
			curPage--;
		}
	}
	
	public void displayNtbk()
	{
		int i;
		for(i = 0; i < pages.size(); i++)
		{
			pages.get(i).display();
		}
	}
	
	public static void main(String [] args)
	{
		Notebook myNtbk = new Notebook(10);
		String Day1 = "Day One\nOnce when I was six years old I saw a magnificent picture in a book, called True Stories from Nature, "
				+ "about the primeval forest. It was a picture of a boa constrictor in the act of swallowing an animal. "
				+ "Here is a copy of the drawing. In the book it said: \"Boa constrictors swallow their prey whole, without chewing it. "
				+ "After that they are not able to move, and they sleep through the six months that they need for digestion.\" "
				+ "I pondered deeply, then, over the adventures of the jungle. And after some work with a colored pencil "
				+ "I succeeded in making my first drawing. My Drawing Number One. It looked something like this:",
				
				Day2 = "Day Two\nI showed my masterpiece to the grown-ups, and asked them whether the drawing frightened them. But they answered: "
				+ "\"Frighten? Why should any one be frightened by a hat?\" My drawing was not a picture of a hat. "
				+ "It was a picture of a boa constrictor digesting an elephant. But since the grown-ups were not able to understand it, ",
				
				Day3 =  "Day Three\nI made another drawing: I drew the inside of a boa constrictor, so that the grown-ups could see it clearly. "
				+ "They always need to have things explained. My Drawing Number Two looked like this: The grown-ups' response, this time, "
				+ "was to advise me to lay aside my drawings of boa constrictors, whether from the inside or the outside, "
				+ "and devote myself instead to geography, history, arithmetic, and grammar. That is why, at the age of six, ",
				
				Day4 = "Day Four\nI gave up what might have been a magnificent career as a painter. I had been disheartened by the failure of "
				+ "my Drawing Number One and my Drawing Number Two. Grown-ups never understand anything by themselves, and it is tiresome "
				+ "for children to be always and forever explaining things to them.",
				
				Day5 = "Day Five\nSo then I chose another profession, and learned to pilot airplanes. "
				+ "I have flown a little over all parts of the world; and it is true that geography has been very useful to me. "
				+ "At a glance I can distinguish China from Arizona. If one gets lost in the night, such knowledge is valuable.",
						
				Day6 = "Day  Six\nIn the course of this life I have had a great many encounters with a great many people who have been concerned with matters of "
				+ "consequence. I have lived a great deal among grown-ups. I have seen them intimately, close at hand. ",
				
				Day7 = "Day Seven\nAnd that hasn't much improved my opinion of them. Whenever I met one of them who seemed to me at all clear-sighted, "
				+ "I tried the experiment of showing him my Drawing Number One, which I have always kept. I would try to find out, so, "
				+ "if this was a person of true understanding. But, whoever it was, he, or she, would always say:\"That is a hat.\"",
				
				Day8 = "Then I would never talk to that person about boa constrictors, or primeval forests, or stars. I would bring myself down "
				+ "to his level. I would talk to him about bridge, and golf, and politics, and neckties. And the grown-up would be greatly "
				+ "pleased to have met such a sensible man.";
		myNtbk.writeOnCurrentPage(Day1);	
		//System.out.println(myNtbk.retrieveCurrentPage());
		myNtbk.flipBkwd();
		myNtbk.writeOnCurrentPage("***End of Page 1***");
		
		myNtbk.flipFwd();
		myNtbk.writeOnCurrentPage(Day2);
		myNtbk.flipFwd();
		myNtbk.writeOnCurrentPage(Day3);
		myNtbk.flipFwd();
		myNtbk.flipFwd();
		myNtbk.flipFwd();
		myNtbk.flipBkwd();
		myNtbk.writeOnCurrentPage(Day4);
		
		myNtbk.displayNtbk();
	}
	
}
