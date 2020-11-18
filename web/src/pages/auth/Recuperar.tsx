import React from "react";
import {
  Box,
  Button,
  ButtonGroup,
  Center,
  FormControl,
  Heading,
  Input,
  InputGroup,
  InputLeftElement,
  LightMode,
  Link,
  Stack,
  Text,
} from "@chakra-ui/react";
import { Icon } from "@chakra-ui/react";
import { FiMail } from "react-icons/fi";
import { Link as ReactRouterDom } from "react-router-dom";

import Card from "../../components/Card";

const Recuperar: React.FC = () => {
  return (
    <LightMode>
      <Center
        height="100vh"
        width="100%"
        position="relative"
        background="linear-gradient(-135deg, #1de9b6 0%, #1dc4e9 100%)"
      >
        <Box w="390px" p={4} zIndex="5" position="relative" boxShadow="md">
          <Card boxShadow="2xl">
            <Stack
              textAlign="center"
              py={8}
              px={[4, 6]}
              flex="1 1 auto"
              spacing={6}
            >
              <Box>
                <Icon
                  as={FiMail}
                  fontSize={30}
                  color="#1de9b6"
                  _before={{
                    background:
                      "linear-gradient(-135deg, #1de9b6 0%, #1dc4e9 100%)",
                  }}
                />
              </Box>
              <Heading as="h3" fontWeight="400" color="black">
                Recuperar Senha
              </Heading>
              <FormControl mb={-2} id="first-name" isRequired>
                <InputGroup size="lg">
                  <InputLeftElement
                    p={0}
                    h="2.9rem"
                    top="0.1rem"
                    left="0.1rem"
                    borderLeftRadius="0.375rem"
                    bg="brand.100"
                    pointerEvents="none"
                    children={<FiMail />}
                  />
                  <Input
                    type="text"
                    placeholder="Nome"
                    pl={16}
                    bg="brand.50"
                    autoComplete="off"
                  />
                </InputGroup>
              </FormControl>
              <ButtonGroup mb={2}>
                <Button
                  size="lg"
                  colorScheme="blue"
                  shadow="xl"
                  w={36}
                  mx="auto"
                >
                  Resetar
                </Button>
              </ButtonGroup>
              <Text fontSize="0.9rem" mb={-3}>
                Entrar no sistema?
                <Link
                  as={ReactRouterDom}
                  to="/login"
                  fontWeight="bold"
                  color="gray.800"
                >
                  {" "}
                  Login
                </Link>
              </Text>
              <Text fontSize="0.9rem">
                Não tem conta?
                <Link
                  as={ReactRouterDom}
                  to="/cadastrar"
                  fontWeight="bold"
                  color="gray.800"
                >
                  {" "}
                  Cadastrar
                </Link>
              </Text>
            </Stack>
          </Card>
        </Box>
      </Center>
    </LightMode>
  );
};

export default Recuperar;
