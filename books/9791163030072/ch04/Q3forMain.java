public class Q3forMain
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IntStack st = new IntStack(64);

        while(true) {
            System.out.println("[현재 데이터 수 : "+(st.sizeOfLeft()+st.sizeOfRight())+" / "+ st.capacity()+"]");
            System.out.println("(1)왼쪽스택 (2)오른쪽스택\n번호 입력 : ");
            int stNum = sc.nextInt();

            System.out.print("(1)푸시 (2)팝 (3)피크 (4)덤프 (5)가득찼는지 (6)비어있는지 (7)검색 (8)초기화 (0)종료\n번호 입력 : ");

            int num = sc.nextInt();
            if(num == 0) break;

            switch (num){
                case 1 :
                    System.out.print("데이터 : ");
                    try{
                        if(stNum % 2 == 1)
                            st.push(sc.nextInt());
                        else st.pushToRight(sc.nextInt());
                    } catch (IntStack.OverFlowIntStackException e){}
                    break;
                case 2:
                    try{
                        if(stNum % 2 == 1)
                            System.out.println(st.popOfLeft());
                        else System.out.println(st.popOfRight());
                    } catch (IntStack.EmptyIntStacKException e) {}
                    break;
                case 3:
                    try {
                        if(stNum % 2 == 1)
                            System.out.println(st.peekForLeft());
                        else System.out.println(st.peekForRight());
                    } catch (IntStack.EmptyIntStacKException e) {}
                    break;
                case 4:
                    try {
                        if(stNum % 2 == 1)
                            st.dumpLeft();
                        else st.dumpRight();
                    } catch(IntStack.EmptyIntStacKException e) {}
                    break;
                case 5:
                    if(st.isFull())
                        System.out.println(">> 스택이 가득찼습니다.");
                    else System.out.println(">> 스택이 가득차지 않았습니다.");
                    break;
                case 6:
                    boolean tmp;
                    if(stNum % 2 == 1) tmp = st.isLeftEmpty();
                    else tmp = st.isRightEmpty();

                    if(tmp)
                        System.out.println(">> 스택이 비어있습니다.");
                    else System.out.println(">> 스택이 비어있지 않습니다.");
                    break;
                case 7:
                    System.out.print("검색할 데이터 입력 : ");
                    int value;
                    if(stNum % 2 == 1)
                        value = st.indexOfLeft(sc.nextInt());
                    else value = st.indexOfRight(sc.nextInt());

                    if(value == -1)
                        System.out.println("찾는 데이터가 없습니다.");
                    else{
                        System.out.println("찾는 데이터는 "+(value+1)+"번째에 있습니다.");
                    }
                    break;
                case 8:
                    if(stNum % 2 == 1) st.clearLeft();
                    else st.clearRight();
                    break;
                default:
                    System.out.println("번호를 다시 입력하세요.");
            }
        }
    }
}
