
public class BinaryTree 
{
	public void insert(Node perent,int key)
	{
		if(key < perent.getKey())
		{
			if (perent.getLeft() != null) 
			{
				insert(perent.getLeft(),key);
			}
			else
			{
				perent.setLeft(new Node(key));
				System.out.println("The node have been added\n");
			}
		}
		
		else if(key > perent.getKey())
		{
			if (perent.getRight() != null) 
			{
				insert(perent.getRight(),key);
			}
			else
			{
				perent.setRight(new Node(key));
				System.out.println("The node have been added\n");
			}
		}
		
	}
	
	
}
