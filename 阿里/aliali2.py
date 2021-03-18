while 1:
    T = int(input())
    for i in range(T):
        nm = list(map(int, input().split()))
        n = nm[0]
        m = nm[1]
        xylist = []
        for i in range(m):
            xy = list(map(int, input().split()))
            xylist.append(xy)
        for i in xylist:
            x = i[0]
            y = i[1]
            print(2)