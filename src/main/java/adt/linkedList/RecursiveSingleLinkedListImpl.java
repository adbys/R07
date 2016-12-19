package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	public RecursiveSingleLinkedListImpl(T data,
			RecursiveSingleLinkedListImpl<T> next) {
		this.data = data;
		this.next = next;
	}

	@Override
	public boolean isEmpty() {
		if (this.getData() == null && this.getNext() == null) {
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public int size() {
		int size = 0;
		
		if (this.getNext() == null) {
			return size;
		} else {
			return 1 + this.getNext().size();
		}
	}

	@Override
	public T search(T element) {
		if (this.getData() == null) {
			return null;
		} else {
			if (this.getData().equals(element)) {
				return this.getData();
			} else {
				return this.getNext().search(element);
			}
		}
	}

	@Override
	public void insert(T element) {
		if (this.getData() == null) {
			this.setData(element);
			this.setNext(new RecursiveSingleLinkedListImpl());
		} else {
			this.getNext().insert(element);;	
		}
	}

	@Override
	public void remove(T element) {
		if(this.getData() == null) {
			return;
		} else {
			if (this.getData().equals(element)) {
				this.setData(this.getNext().getData());
				this.setNext(this.getNext().getNext());
			} else {
				this.getNext().remove(element);
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[this.size()];
		
		int count = 0;
		
		this.toArray(array, count);
		
		return array;
	}
	
	private void toArray(T[] array, int count) {
		if (count < array.length) {
			array[count++] = this.getData();
			if (this.getNext() != null) {
				this.getNext().toArray(array, count);							
			}
		}
	}
	

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
