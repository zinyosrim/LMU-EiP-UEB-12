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
		if (this.isEmpty())
			this.head = newLast;									//Wenn Liste leer, mache newLast das 1. Element
		else{														//sonst...
			Entry<T> e = this.head;
			while ( e.getNext() != null ) e = e.getNext();			//... iteriere bis zum letzten Element
			e.setNext(newLast);										//setze den Zeiger vom Letzten auf newLast
		}
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
		List<T> cloneList	= new List<T>();						//erzeuge leere Clone-Liste
		Entry<T> entry		= this.head;							//Iterationselement für Ursprungsliste

		for (int i = 0; i < this.size; i++){						//solange Ende der Ursprungsliste nicht erreicht...
			cloneList.postfix(new Entry<T>(entry.getElement()));	//erzeuge neues Entry und hänge es an die Liste
			entry = entry.getNext();								//setze Iterations-Entry auf das Nächste
		}
		return cloneList;
	}

	public List<T> concatClone(List<T> list){
		// TODO e)
		List<T>  concatCloneList 	= this.clone();		 	 		//Klonlisten werden erzeugt
		List<T>  concatCloneList2 	= list.clone();
		Entry<T> entry 				= concatCloneList.head;  		//Iterationselement
		while (entry.getNext() != null)							 	//gehe zum letzten Entry der 1. Liste
			entry = entry.getNext();
		entry.setNext(concatCloneList2.head); 						//Setze den Zeiger auf 1. Elem. von Copy von Liste 2
		concatCloneList.size 		= concatCloneList.size()
									+ concatCloneList2.size();
		return concatCloneList;
	}

	public List<T> reverse() {
		// TODO f)
		List<T>  reverseList 		= new List<T>(); 				//initialisiere neue Liste
		Entry<T> currentEntry		= this.head;					//Iterationselement für Ursprungsliste
		//gehe Ursprungsliste durch und setze das jeweils aktuelle Element an den Anfang der reverseList
		for (int counter = 0; counter <= this.size+1; counter++){
			reverseList.prefix ( new Entry<T>( currentEntry.getElement() ) );
			currentEntry = currentEntry.getNext();
		}
		return reverseList;
	}

	public void removeDuplicates() {
		// TODO g)
		Entry<T> current = this.head; 								//Laufvariable äussere Schleife
		while (current != null){                                    //durchlaufe Liste bis zum Ende
			Entry<T> other = current.getNext(); 					//Laufvariable innere Schleife
			Entry<T> temp=current;									//Speichervariable für Vorgänger vom Duplikat
			while (other != null){                                  //Durchlaufe alle Nachfolger bis zum Ende
				if (current.getElement() == other.getElement() ){	//Duplikat gefunden? -> entferne es
					temp.setNext(other.getNext());					//Setze Zeiger vom Vorgänger auf Nachfolger
					other = temp;
					this.size--;									//Duplikat entfernt, dekrementiere Listengroesse
				}
				temp = other;                                       //mache weiter, es kann ja weitere Duplikate geben
				other = other.getNext();
			}
			current = current.getNext();                            //äussere Schleife, gehe zum nächsten El. weiter
		}
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