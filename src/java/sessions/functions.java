package sessions;
public class functions {
    
    public static int cidAlreadyPresentFlag;
    public static String registeringUser;
    
    public static int leaveAppliedFlag;
    public static int displayLeave;
    public static int numberOfLeaves;
    public static int noleavesfoundFlag;
    public static int displayleaveAtAdmin;
    public static int peerDisplayFlag;
    
    public static void delocateFlags()
    {
        cidAlreadyPresentFlag=0;
        leaveAppliedFlag=0;
        displayLeave=0;
        displayleaveAtAdmin=0;
        noleavesfoundFlag=0;
        peerDisplayFlag=0;
    }
}
