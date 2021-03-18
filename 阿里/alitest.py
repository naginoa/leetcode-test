while 1:
    try:
        nl = input()
        if nl == '':
            continue
        nl = list(map(int, nl.split()))
        n = nl[0]
        l = nl[1]
        res = []
        isans = 0
        for i in range(2, 100):
            if i % 2 == 0:
                if ((n / i) - 0.5) - int((n / i) - 0.5) < 0.00001:
                    flag = 1
                    fuhao = -1
                    zengliang = 0
                    while flag <= i:
                        res.append(int(fuhao * (0.5+zengliang) + n/i))
                        fuhao *= -1
                        if flag % 2 == 0:
                            zengliang += 1
                        flag += 1
                    flag = 1
                    res.sort()
                    if min(res) > l:
                        print(' '.join(list(map(str, res))))
                        isans = 1
                        break
                    res = []
            else:
                if n / i - int(n / i) < 0.00001:
                    flag = 1
                    fuhao = -1
                    zengliang = 0
                    while flag <= i:
                        res.append(int(fuhao * (0+zengliang) + n/i))
                        fuhao *= -1
                        if flag % 2 != 0:
                            zengliang += 1
                        flag += 1
                    flag = 1
                    res.sort()
                    if min(res) > l:
                        print(' '.join(list(map(str, res))))
                        isans = 1
                        break
                    res = []
        if isans == 0:
            print('No')
    except:
        break




