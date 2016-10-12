import re

def getLen(h,l,w):
	return h*l*w + smallest(h,l,w)

def smallest(h,l,w):
	if h >= l and h >= w:
		return 2*l + 2*w
	elif l >= h and l >= w:
		return 2*h + 2*w
	else:
		return 2*l + 2* h

def main(file):
	text = open(file,'r')
	ribbon = 0
	for line in text:
		digits = [int(d) for d in re.findall('\d+',line)]
		ribbon += getLen(digits[0],digits[1],digits[2])
	return ribbon

print(main("input.txt"))