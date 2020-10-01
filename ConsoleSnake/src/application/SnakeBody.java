package application;


public class SnakeBody extends GameObject {
	
	public Node head;
	private Node tail;
		
	private class Node{
		Snake item;
		Node next;
		private Node(Snake s, Node n) {
			item = s;
			next = n;
		}	
	}
	
	SnakeBody(int SNAKE_STARTING_X, int SNAKE_STARTING_Y,GameScreen screen){
		tail= new Node(new Snake('o',SNAKE_STARTING_X+1,SNAKE_STARTING_Y),null);
		head = new Node(new Snake('@',SNAKE_STARTING_X,SNAKE_STARTING_Y),tail);
		screen.setObjectOnLocation(head.item, SNAKE_STARTING_X, SNAKE_STARTING_Y);
		screen.setObjectOnLocation(tail.item, tail.item.getX(), tail.item.getY());
	}

	public void connectToTail(Node n) {
		Node oldTail = getTail();
		tail = n;
		oldTail.next = n;
	}
	
	private Node getTail() {
		Node aux = head;
		while(aux.next != null) {
			aux = aux.next;
			aux.item.setSymbol('O');
		}
		return aux;
	}
	
	public Snake getSnakeHead() {
		return head.item;
	}
	
	public Snake getSnakeTail() {
		return tail.item;
	}

	
	public void increaseSnake(GameScreen screen){
		connectToTail(new Node(new Snake('o',tail.item.getX()+1,tail.item.getY()),null));	
	}
	
	public void moveBodyLeft(GameScreen screen) {
		int x = head.item.getX();
		int y = head.item.getY();
		moveBody(screen,head.next, x,y);
		head.item.moveLeft(screen, head.item);
		
	}
	public void moveBodyRight(GameScreen screen) {
		int x = head.item.getX();
		int y = head.item.getY();
		moveBody(screen,head.next, x,y);
		head.item.moveRight(screen, head.item);
	}
	public void moveBodyUp(GameScreen screen) {
		int x = head.item.getX();
		int y = head.item.getY();
		moveBody(screen,head.next,x,y);
		head.item.moveUp(screen, head.item);
	}
	public void moveBodyDown(GameScreen screen) {
		int x = head.item.getX();
		int y = head.item.getY();
		moveBody(screen,head.next, x,y);
		head.item.moveDown(screen, head.item);
	}
	
	private void moveBody(GameScreen screen,Node n, int x, int y) {
		if(n!=null) {
			int oldX = n.item.getX();
			int oldY = n.item.getY();
			n.item.setX(x);
			n.item.setY(y);
			screen.ClearScreenLocation(oldX, oldY);
			screen.setObjectOnLocation(n.item, n.item.getX(), n.item.getY());			
			moveBody(screen,n.next,oldX,oldY);
		}		
	}
	public void printSnake() {
		Node aux = head;
		while(aux!=null) {
			System.out.print(aux.item.getSymbol());
			aux=aux.next;
		}
	}
	
	public void minimizeSnake() {
		head.next = tail;
	}

	

}