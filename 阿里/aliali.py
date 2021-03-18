while 1:
    try:
        nm = list(map(int, input().split()))
        n = nm[0]
        m = nm[1]
        abdict = {}
        for i in range(m):
            ab = list(map(int, input().split()))
            abdict.update({ab[0]:ab[1]})
        q = int(input())
        temp = []
        for i in range(q):
            xylist = list(map(int, input().split()))
            temp.append(xylist)
        for i in temp:
            x = i[0]
            y = i[1]
            flag = 0
            if y not in abdict.values():
                print(-1)
                break
            t = x
            if abdict[t] == y:
                print(1)
                break
            while t in abdict.keys():
                t = abdict[t]
                flag += 1
                if t == y:
                    print(flag)
                    break

    except:
        break