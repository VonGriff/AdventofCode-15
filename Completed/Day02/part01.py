class Present(object):
	"""docstring for Present"""
	def __init__(self, height, width, length):
		self.height = height
		self.width = width
		self.length = length

	def getDim(self):
		return 2*self.height*self.width + 2*self.height*self.length + 2*self.width*self.length + self.smallestSide()

	def smallestSide(self):
		small = self.height*self.width
		hl = self.height*self.length
		wl = self.width*self.length

		if hl < small:
			small = hl
		if wl < small:
			small = wl

		return small


def main(file):
	text = open(file, 'r')
	presents = []	#An array of all presents

	for line in text:
		hlw = line.split('x')
		presents.append(Present(int(hlw[0]),int(hlw[1]),int(hlw[2])))

	paper = 0
	for p in presents:
		paper += p.getDim()
	return paper

print(main("input.txt"))