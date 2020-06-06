import java.io.Serializable;

class SingletonClassCreator{

    public static void main(String args[]){

        Singleton SingletonObject = Singleton.getInstance();
        System.out.println(SingletonObject);
        System.out.println(SingletonObject.clone());
        SingletonWithEnum singletonWithEnum = SingletonWithEnum.INSTANCE;
        System.out.println(singletonWithEnum.getValue());
        singletonWithEnum.setValue(2);
        System.out.println(singletonWithEnum.getValue());


    }

}

class Singleton implements Cloneable, Serializable
{
    /**
    	 *
    	 */
    private static final long serialVersionUID = 1L;
    private static volatile Singleton _instance;

    private Singleton(){    
    }

    public static Singleton getInstance(){
        if(_instance == null){
            synchronized(Singleton.class){
                if(_instance == null){
                    _instance = new Singleton();
                }
            }
        }
        return _instance;
    }

    public Singleton clone(){
    return _instance;
    }

    public Singleton readResolve(){
        return _instance;
    }

}

