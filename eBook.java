
public class eBook extends Readable {			//class ebook, inherits from readables
	
	@Override									//annotation for overriding
	public int getPrice(int input){				//override method in Readables
		return super.getPrice(input);			//call the method in the superclass
	}											//close the body
}												//close the body
