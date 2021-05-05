package uaslp.ingenieria.labs.list;

public class ArrayList<H> implements List<H>{

    private Object array[];
    private int size;

    public ArrayList(){
        this.array = new Object[2];
    }

    @Override
    public void add(H data) {
        if(size == array.length){
            Object arrayAux[] = new Object[array.length + 2];

            for(int i = 0; i < array.length; i++){
                arrayAux[i] = array[i];
            }

            this.array = new Object[arrayAux.length];

            for(int i = 0; i < array.length; i++){
                array[i] = arrayAux[i];
            }
        }
        this.array[size] = data;
        size++;
    }

    @Override
    public H get(int index) {
        return (H)array[index];
    }

    @Override
    public void delete(int index) throws IndexOutOfBoundsException{
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }

        for (int i = index; i < size-1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Iterator<H> getIterator() {
        return new ForwardIterator();
    }

    @Override
    public Iterator<H> getReverseIterator() {
        return new ReverseIterator();
    }

    public class ForwardIterator implements Iterator<H> {

        private int currentIndex;

        public ForwardIterator(){
            this.currentIndex = 0;
        }

        @Override
        public boolean hasNext(){
            return currentIndex < size;
        }

        @Override
        public H next(){
            H data = (H)array[currentIndex];
            currentIndex++;
            return data;
        }
    }

    public class ReverseIterator implements Iterator<H>{

        private int currentIntex;

        public ReverseIterator(){
            this.currentIntex = size-1;
        }

        @Override
        public boolean hasNext(){
            return currentIntex >= 0;
        }

        @Override
        public H next(){
            H data = (H)array[currentIntex];
            currentIntex--;
            return data;
        }
    }
}
