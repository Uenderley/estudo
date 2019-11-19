import spacy
nlp = spacy.load('pt')

def process_text(text):
    doc = nlp(text.lower())
    result = []
    for token in doc:
        if token.text in nlp.Defaults.stop_words:
            continue
        if token.is_punct:
            continue
        if token.lemma_ == '-PRON-':
            continue
        result.append(token.lemma_)
    return " ".join(result)

def calcular():
    texto2 = "O candidato cometeu um crime pois não fez um show conforme havia dito"
    texto1 = "Cometeu um crime o candidato pois o show não foi feito conforme havia dito"

    primeiro = process_text(texto1)
    segundo = process_text(texto2)

    docP =  nlp(primeiro)
    docS =  nlp(segundo)

    print(docP.similarity(docS))

    doc1 =  nlp(texto1)
    doc2 =  nlp(texto2)
    print(doc1.similarity(doc2))

calcular()

