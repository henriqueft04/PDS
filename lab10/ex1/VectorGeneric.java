import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class VectorGenerator<T> implements ListIterator<T> {
	private VectorGeneric<T> vec;
	private int i = 0;

	public VectorGenerator(VectorGeneric<T> vec) {
		this.vec = vec;
	}

	public VectorGenerator(VectorGeneric<T> vec, int i) {
		this.vec = vec;
		this.i = i;
	}

	public boolean hasNext() {
		return i < vec.totalElem();
	}

	public T next() {
		return vec.getElem(i++);
	}

	public void remove() {
		vec.removeElem(vec.getElem(i));
	}

	public void set(T e) {
		VectorGeneric<T> new_vector = new VectorGeneric<T>();
		for (int j = 0; j < vec.totalElem(); j++) {
			if (j == i) {
				new_vector.addElem(e);
			} else {
				new_vector.addElem(vec.getElem(j));
			}
		}
		vec = new_vector;
	}

	public int previousIndex() {
		return i-1;
	}

	public int nextIndex() {
		return i+1;
	}

	public boolean hasPrevious() {
		return i > 0;
	}

	public T previous() {
		return vec.getElem(i--);
	}

	public void add(T e) {
		VectorGeneric<T> new_vector = new VectorGeneric<T>();
		for (int j = 0; j < vec.totalElem(); j++) {
			if (j == i) {
				new_vector.addElem(e);
			}
			new_vector.addElem(vec.getElem(j));
		}
		vec = new_vector;
	}
}


public class VectorGeneric<T> {
	private T[] vec;		
	private int nElem;	      
	private final static int ALLOC = 50;   
	private int dimVec = ALLOC;     

	@SuppressWarnings("unchecked")
	public VectorGeneric() {
		vec = (T[]) new Object[dimVec];
		nElem = 0;
	}

	public Iterator<T> Iterator() {
		return new VectorGenerator<T>(this);
	}

	public ListIterator<T> ListIterator() {
		return new VectorGenerator<T>(this);
	}

	public ListIterator<T> ListIterator(int i) {
		return new VectorGenerator<T>(this, i);
	}

	
	public boolean addElem(T elem) {
		if (elem == null)
			return false;
		ensureSpace();
		vec[nElem++] = elem;
		return true;
	}

	private void ensureSpace() {
		if (nElem>=dimVec) {
			dimVec += ALLOC;
			@SuppressWarnings("unchecked")
			T[] newArray = (T[]) new Object[dimVec];
			System.arraycopy(vec, 0, newArray, 0, nElem );
			vec = newArray;
		}
	}

	public boolean removeElem(T elem) {
		for (int i = 0; i < nElem; i++) {
			if (vec[i].equals(elem)) {
				if (nElem-i-1 > 0) // not last element
					System.arraycopy(vec, i+1, vec, i, nElem-i-1 );
				vec[--nElem] = null; // libertar último objecto para o GC
				return true;
			}
		}
		return false;
	}

	public int totalElem() {
		return nElem;
	}
	
	public T getElem(int i) {
		return (T) vec[i];
	}
}
