
public class Node {
	private int node_id;
	private int community_id;
	private int timestep;
	
	public Node(int node_id, int community_id, int timestep) {
		super();
		this.node_id = node_id;
		this.community_id = community_id;
		this.timestep = timestep;
	}

	public int getNode_id() {
		return node_id;
	}

	public void setNode_id(int node_id) {
		this.node_id = node_id;
	}

	public int getCommunity_id() {
		return community_id;
	}

	public void setCommunity_id(int community_id) {
		this.community_id = community_id;
	}

	public int getTimestep() {
		return timestep;
	}

	public void setTimestep(int timestep) {
		this.timestep = timestep;
	}
	
	

}
