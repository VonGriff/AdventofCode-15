def read(file):
	level = 0
	pos = 0
	text = open(file, 'r')

	while (True):
		pos += 1
		c = text.read(1)
		if c == '(':
			level += 1
		elif c == ')':
			level -= 1
		if level == -1:
			return pos

print(read("input.txt"))