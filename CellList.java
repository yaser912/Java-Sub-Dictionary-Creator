package part2;

public class CellList {
	private CellNode head;
	private int size;
	
	public class CellNode {
		protected CellPhone cell;
		protected CellNode next;
		
		public void Node (CellPhone c) {
			this.setCell(c);
		}
		
		public CellNode() {						//
			this.cell =null;
		}
		
		public CellNode(CellPhone phone) {
			this.setCell(phone);
		}
		
		public CellNode(CellNode o) {
			this.setCell(o.getCell());
		}

		public CellPhone getCell() {			// Getter
			return this.cell;
		}

		public void setCell(CellPhone c1) {		// Setter
			this.cell=c1;
		}
		
	}
	
}