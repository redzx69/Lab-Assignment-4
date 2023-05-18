public class Room {
    private String block;
    private String level;
    private String no;

    public Room(String block, String level, String no) {
        this.block = block;
        this.level = level;
        this.no = no;
    }

    public void setRoom(String block, String level, String no) {
        this.block = block;
        this.level = level;
        this.no = no;
    }

    public String getBlock() {
        return block;
    }

    public String getLevel() {
        return level;
    }

    public String getNo() {
        return no;
    } 
}