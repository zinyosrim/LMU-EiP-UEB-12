public class ListProgram{

	public static void main(String[] args) {

		List<Integer> list = new List<>();
		list.prefix(2);
		//System.out.println("list nach prefix 2: "+list);
		list.postfix(5);
		//System.out.println("list nach postfix 5: "+list);
		list.prefix(9);
		list.postfix(5);
		list.prefix(6);
		list.postfix(2);
		list.prefix(5);
		list.postfix(22);
		//System.out.println("list: "+list+" DYNSIZE: "+list.sizeDyn());
		//System.out.println("klonlist: "+list.clone());
		System.out.println("list: "+list);


		List<Integer> list2 = new List<>();
		list2.prefix(5);
		list2.postfix(8);
		list2.postfix(33);
		list2.prefix(1);
		list2.postfix(32);
		System.out.println("list2: "+list2);

		list.concat(list2);
		System.out.println("list nach concat mit list2: "+list);

		list2.postfix(19);
		System.out.println("list nach list2.postfix(19): "+list);

		List<Integer> list3 = list.concatClone(list2);
		list2.postfix(29);
		System.out.println("list3=list.concatClone(list2): "+list3);

		List<Integer> list4 = list.reverse();
		System.out.println("list4: "+list4);

		// sollte zuletzt ausgeben:
		// (29, 19, 32, 33, 8, 5, 1, 22, 2, 5, 5, 2, 9, 6, 5)

		List<Integer> list5 = new List<>();
		list5.postfix(2);
		list5.postfix(2);
		list5.postfix(5);
		list5.postfix(9);
		list5.postfix(5);
		list5.postfix(6);
		list5.postfix(2);
		list5.postfix(5);
		list5.postfix(22);
		list5.postfix(22);

		System.out.println("list5: "+list5);

		list5.removeDuplicates();
		System.out.println("list5 with no duplicates: "+list5);



	}
}