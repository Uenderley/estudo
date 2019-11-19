import spacy

nlp = spacy.load('pt')

doc = nlp(u'Você encontrou o livro que eu te falei, Carla?')
doc2 = nlp("Você achou o livro que eu te falei, Carla?")
doc3 = nlp("Carla? Você achou o livro que eu te falei")
doc4 = nlp("Maria? Você achou o martelo que eu te falei")
doc5 = nlp("Maria? você nunca entende o que eu te falo")

print(nlp.Defaults.stop_words)


print(doc.similarity(doc2))
print(doc3.similarity(doc2))
print(doc.similarity(doc3))
print(doc3.similarity(doc4))
print(doc3.similarity(doc5))

#a = doc.text.split()
#print(a)

#for token in doc:
#    if not token.is_punct:
  #      print(token)

tokens = [token for token in doc]
#print(tokens)