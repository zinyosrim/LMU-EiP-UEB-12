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
		Entry<T> e 			= this.head;				 //Iterations-Entry für zu klonende Liste
		Entry<T> newEntry;								 //Variable zur Speicherung des neuen Klon-Entry
		List<T>  cloneList 	= new List();				 //Klonliste wird erzeugt
		Entry<T> prev 		= new Entry(e.getElement()); //vorheriges Entry wird zwischengespeichert

		cloneList.size		= this.size;				 //Initialisierung der zu klonenden Liste
		cloneList.head		= prev;

		while (e.getNext() != null){					 //solange Ende der zu klonenen Liste nicht erreicht ...
			e				= e.getNext();				 //iteriere in Ursprungsliste ein Element weiter
			newEntry		= new Entry(e.getElement()); //erzeuge neues Clone-Entry mit Ursprungswert
			cloneList.postfix(newEntry);				 //hänge das Element an Klonliste hintendran
			prev.setNext(newEntry);						 //setze Zeiger vom vorherigen Element
			prev			=	newEntry;				 //Zwischenspeichern vom aktuellen Klon-Element
		}
		return cloneList;
	}

 	// Vorteile clone: Einfaches umhängen führt zur neuen Liste. Schnelle Operation
	// Vorteile concatClone: erzeugt neue Liste, Änderungen an den Ursprungslisten haben keinen Einfluss auf neue Liste
	public List<T> concatClone(List<T> list){
		// TODO e)
		List<T>  concatCloneList1 	= this.clone();		 	 //Klonlisten werden erzeugt
		List<T>  concatCloneList2 	= list.clone();
		Entry<T> last 				= concatCloneList1.head; //Iterationselement
		while (last.getNext() != null){
			last = last.getNext();
		}
		last.setNext(concatCloneList2.head);
		concatCloneList1.size += concatCloneList2.size();
		return concatCloneList1;
	}

//	public List<T> reverse() {
//		// TODO f)
//	}

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