package halmapoc.extraUtil;

public enum StageName{
    REGISTER("register"), LOGIN("login"), MAINMENU("mainmenu"),
    MAINMENUAUTH("mainemenuauth"), GAMERULES("gamerules");

    final String stageName;

    StageName(String stageName){
        this.stageName = stageName;
    }

    public String toString(){
        return stageName;
    }
}
