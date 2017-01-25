public class List<T> {
	private int size;
	private Entry<T> head;

	public List() {
		this.size = 0;
		this.head = null;
	}

	public int size() {
		return this.size;
	}

	public T first() {
		if(this.head == null)
			return null;
		return this.head.getElement();
	}

	public T last() {
		// TODO a)
		Entry<T> e = this.head;
		while (e.getNext() != null){
			e = e.getNext();
		}
		return e.getElement();
	}

	public void prefix(Entry<T> newHead) {
		newHead.setNext(this.head);
		this.head = newHead;
		this.size++;
	}

	public void prefix(T element) {
		this.prefix(new Entry(element));
	}


	public void postfix(Entry<T> newLast) {
		// TODO b)
		Entry<T> e = this.head;
		while (e.getNext() != null){
			e = e.getNext();
		}
		e.setNext(newLast);
		newLast.setNext(null);
		this.size++;
	}

	public void postfix(T element) {
		this.postfix(new Entry(element));
	}

	public List<T> rest() {
		if(this.head == null)
			return null;
		List<T> erg = new List<T>();
		erg.size = this.size - 1;
		erg.head = this.head.getNext();
		return erg;
	}

	public T proj(int index){
		if(this.head == null) {
			return null;
		}
		if(index >= this.size())
			return null;
		if(index == 1)
			return this.head.getElement();
		else
			return this.rest().proj(index - 1);
	}

	public boolean isEmpty() {
		return this.head == null;
	}

	public void concat(List<T> list){
		// TODO c)

		Entry<T> e = this.head;
		while (e.getNext() != null){
			e = e.getNext();
		}
		e.setNext(list.head);
		this.size += list.size();
	}


	public List<T> clone(){
		// TODO d)
		List<T> cloneList	= new List<T>();					//erzeuge leere Clone-Liste
		Entry<T> entry		= this.head;						//Iterationselement für Ursprungsliste

		for (int i = 0; i < this.size; i++){					//solange Ende der Ursprungsliste nicht erreicht...
			cloneList.prefix(new Entry<T>(entry.getElement()));	//erzeuge neues Entry und hänge es an die Liste
			entry = entry.getNext();							//setze Iterations-Entry auf das Nächste
		}
		return cloneList;
	}

	public List<T> concatClone(List<T> list){
		// TODO e)

		List<T>  concatCloneList 	= this.clone();		 	 //Klonlisten werden erzeugt
		Entry<T> last 				= concatCloneList.head;  //Iterationselement
		System.out.println("concatclone  this.size "+this.size+" list.size "+list.size());
		while (last.getNext() != null){						 //gehe zum letzten Entry der 1. Liste
			last = last.getNext();
		}
		last.setNext(list.head); //Setze den Zeiger auf das 1. Element von Liste 2

		concatCloneList.size = this.size + list.size();
		System.out.println("concatCloneList.size "+concatCloneList.size());
		System.out.println(concatCloneList);
		return concatCloneList;
		/* clone: Einfaches Umhängen führt zur neuen Liste. Schnelle Operation. Allerdings wenn
		   nachträgliche Änderungen an den ursprünglichen Listen erfolgen, kann die ungewollte Effekte haben.
		   concatClone: erzeugt neue Liste, Änderungen an den Ursprungslisten haben
		   keinen Einfluss auf neue Liste. Dafür ist es langsamer als clone, weil man um die Kopien
		    zu erzeugen durch die Listen iterieren muss -> lineare Komplexität */
	}

	public List<T> reverse() {
		// TODO f)
		List<T>  reverseList 	= new List<T>(); 	//initialisiere neue Liste
		Entry<T> currentEntry	= this.head;		//Iterationselement für Ursprungsliste

		for (int counter = 0; counter <= this.size+1; counter++){
			reverseList.prefix ( new Entry<T>( currentEntry.getElement() ) );
			currentEntry = currentEntry.getNext();
		}
		return reverseList;
	}

	public void removeDuplicates() {
		// TODO g)
	}

	public String toString(){
		if(isEmpty())
			return "()";
		String str = "(";
		Entry<T> entry = head;
		while(entry != null) {
			str += entry.getElement();
			entry = entry.getNext();
			if(entry != null)
				str += ", ";
		}
		str += ")";
		return str;
	}

	// for i)
	public int sizeDyn() {
		int size = 0;
		if(this.head != null){
			Entry<T> entry = this.head;
			while(entry != null){
				size++;
				entry = entry.getNext();
			}
		}
		return size;
	}

}