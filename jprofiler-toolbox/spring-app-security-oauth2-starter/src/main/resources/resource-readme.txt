Password encoding:

PasswordEncoderFactories -> function: createDelegatingPasswordEncoder provides list of id's used to
decrypt passwords in configuration files having this format: "{id}encryptedstring"
example with bcrypt: "{bcrypt}encrypterstring"
for defaults use: "{cypher}encryptedstring"