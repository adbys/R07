package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {
		
	}

	public RecursiveDoubleLinkedListImpl(T data,
			RecursiveSingleLinkedListImpl<T> next,
			RecursiveDoubleLinkedListImpl<T> previous) {
		super(data, next);
		this.previous = previous;
	}

	@Override
	public void insertFirst(T element) {
		if (this.getData() == null) {
			this.setData(element);
			this.setNext(new RecursiveDoubleLinkedListImpl(null, null, null));
			this.setPrevious(new RecursiveDoubleLinkedListImpl(null, null, null));
		} else {
			RecursiveDoubleLinkedListImpl lastHead = new RecursiveDoubleLinkedListImpl(this.getData(), this.getNext(), this);
			this.setData(element);
			this.setNext(lastHead);
			lastHead.setPrevious(this);
		}
	}

	@Override
	public void removeFirst() {
		if(this.isEmpty()) {
			return;
		}
		this.setData(this.getNext().getData());
		this.setNext(this.getNext().getNext());
		this.setPrevious(null);
	}

	@Override
	public void removeLast() {
		if(this.isEmpty()) {
			return;
		}
		 if (this.getNext() == null || this.getNext().getData() == null) {
		          this.setData(null);
		          this.setNext(null);
		          return;
		 }
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
