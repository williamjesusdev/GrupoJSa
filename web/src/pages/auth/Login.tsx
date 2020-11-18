import React from "react";
import {
  Box,
  Button,
  ButtonGroup,
  Center,
  createStandaloneToast,
  FormControl,
  Heading,
  Input,
  InputGroup,
  InputLeftElement,
  LightMode,
  Link,
  Stack,
  Switch,
  Text,
} from "@chakra-ui/react";
import { Icon } from "@chakra-ui/react";
import { FiLock, FiUser, FiUserCheck } from "react-icons/fi";
import { Link as ReactRouterDom, useHistory } from "react-router-dom";
import { useForm } from "react-hook-form";

import { api } from "../../services/api";
import { login as signin } from "../../services/auth";

import Card from "../../components/Card";

interface FormData {
  login: string;
  senha: string;
}

const Login: React.FC = () => {
  const history = useHistory();
  const toast = createStandaloneToast();
  const { register, handleSubmit, reset } = useForm<FormData>();

  const onSubmit = handleSubmit(({ login, senha }) => {
    api
      .post("/usuarios/auth", { login, senha })
      .then((response) => {
        let { login, token } = response.data;
        signin(login, token);
        toast({
          title: "Aê!",
          description: "Logado com Sucesso",
          position: "top-right",
          status: "success",
          duration: 4000,
          isClosable: true,
          onCloseComplete: () => history.push("/"),
        });
      })
      .catch((err) => {
        let { message } = err.response.data;
        toast({
          title: "Ooops!",
          description: message,
          position: "top-right",
          status: "error",
          duration: 4000,
          isClosable: true,
          onCloseComplete: () => reset({ login, senha: "" }),
        });
      });
  });

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
              as="form"
              onSubmit={onSubmit}
            >
              <Box>
                <Icon
                  as={FiUserCheck}
                  fontSize={30}
                  color="#1de9b6"
                  _before={{
                    background:
                      "linear-gradient(-135deg, #1de9b6 0%, #1dc4e9 100%)",
                  }}
                />
              </Box>
              <Heading as="h3" fontWeight="400" color="black">
                Login
              </Heading>
              <FormControl mb={-2} id="first-name" isRequired>
                <InputGroup size="lg">
                  <InputLeftElement
                    p={0}
                    h="2.9rem"
                    top="0.05rem"
                    left="0.1rem"
                    borderLeftRadius="0.375rem"
                    bg="brand.100"
                    pointerEvents="none"
                    children={<FiUser />}
                  />
                  <Input
                    name="login"
                    type="text"
                    placeholder="Nome"
                    pl={16}
                    bg="brand.50"
                    ref={register}
                    autoComplete="off"
                  />
                </InputGroup>
              </FormControl>
              <FormControl mb={-2} id="first-password" isRequired>
                <InputGroup size="lg">
                  <InputLeftElement
                    p={0}
                    h="2.9rem"
                    top="0.05rem"
                    left="0.1rem"
                    bg="brand.100"
                    borderLeftRadius="0.375rem"
                    pointerEvents="none"
                    children={<FiLock />}
                  />
                  <Input
                    name="senha"
                    type="password"
                    placeholder="Senha"
                    pl={16}
                    bg="brand.50"
                    ref={register}
                  />
                </InputGroup>
              </FormControl>
              <Center alignItems="self-end" justifyContent="flex-start">
                <Switch mb={2} mr={2} defaultIsChecked />
                <Text fontSize="0.9rem" mb={-3}>
                  Salvar credenciais
                </Text>
              </Center>
              <ButtonGroup mb={2}>
                <Button
                  type="submit"
                  size="lg"
                  colorScheme="blue"
                  shadow="xl"
                  w={36}
                  mx="auto"
                >
                  Entrar
                </Button>
              </ButtonGroup>
              <Text fontSize="0.9rem" mb={-3}>
                Esqueceu a senha?
                <Link
                  as={ReactRouterDom}
                  to="/recuperar"
                  fontWeight="bold"
                  color="gray.800"
                >
                  {" "}
                  Resetar
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

export default Login;
