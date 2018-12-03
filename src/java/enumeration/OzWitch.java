package java.enumeration;

public enum OzWitch {
    //实例必须最先定义
    WEST("WEST INSTANTCE"),
    NORTH("NORTH INSTANCE"),
    EAST("EAST INSTANCE"),
    SOUTH("SOUTN INSTANCE");
    private String description;
    //如果打算自定义方法，则必须在enum实例序列的最后添加一个分号
    private OzWitch(String description){
        this.description=description;
    }
    public String getDescription(){
        return this.description;
    }

    public static void main(String[] args) {
        for(OzWitch witch:OzWitch.values()){
            System.out.println(witch+" : "+witch.getDescription());
        }
    }
}