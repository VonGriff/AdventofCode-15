import re

def getDim(h,l,w):
	return 2*h*l + 2*h*w + 2*l*w + smallest(h,l,w)

def smallest(h,l,w):
	small = h*l

	if h*w < small:
		small = h*w
	if l*w < small:
		small = l*w

	return small
	# hw = h*w
	# hl = h*l
	# wl = w*l
	# if hw < hl:
	# 	if hw < wl:
	# 		return hw
	# 	else:
	# 		return wl
	# elif hl < wl:
	# 	return hl
	# else:
	# 	return wl

def main(file):
	text = open(file,'r')
	area = 0
	for line in text:
		digits = [int(d) for d in re.findall('\d+',line)]
		area += getDim(digits[0],digits[1],digits[2])
	return area

print(main("input.txt"))