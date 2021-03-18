while 1:
    try:
        nl = input()
        if nl == '':
            continue
        nl = list(map(int, nl.split()))
        n = nl[0]
        l = nl[1]
        res = []
        for i in range(l, 101):
            if (2 * n + i - i * i) % (2 * i) == 0:
                a1 = (2 * n + i - i * i) / (2 * i)
                for j in range(1,i+1):
                    res.append(str(int(a1+j)))
                res.sort()
                print(' '.join(res))
                break
    except:
        break