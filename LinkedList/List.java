public class List{
  private Node root;
  private Node head;
  private int size;
  
  public List(){
    size = 0;
    root = null;
    head = null;
  }

  public Object getRoot(){
    return root;
  }

  public void add(Object element){
    if(size == 0){
      root.data = element;
    }
    else{
      head.next.data = element;
    }
    size++;
  }
}
