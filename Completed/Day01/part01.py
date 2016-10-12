def read(file):
	level = 0
	text = open(file, 'r')

	while (True):
		c = text.read(1)
		if c == '(':
			level += 1
		elif c == ')':
			level -= 1
		else:
			return level

print(read("input.txt"))