import jwt from "jsonwebtoken";

interface Payload {
  sub: string;
  exp: number;
}

export interface Usuario {
  login: string;
  token: string;
}

export const USER_KEY = process.env.REACT_APP_USER_KEY || null;
export const TOKEN_KEY = process.env.REACT_APP_TOKEN_KEY || null;
export const SIGN_KEY = process.env.REACT_APP_SIGN_KEY || null;

export const isAuthenticated = () => {
  const token = getToken() || null;
  if (token) {
    const payload = jwt.decode(token) as Payload;
    const date = new Date(payload.exp * 1000);

    return date >= new Date();
  }
  return false;
};

export const getUsuario = () => USER_KEY && localStorage.getItem(USER_KEY);

export const getToken = () => TOKEN_KEY && localStorage.getItem(TOKEN_KEY);

export const login = (login: string, token: string) => {
  if (USER_KEY && TOKEN_KEY) {
    localStorage.setItem(USER_KEY, login);
    localStorage.setItem(TOKEN_KEY, token);
  }
  return;
};

export const logout = () => {
  if (USER_KEY && TOKEN_KEY) {
    localStorage.removeItem(USER_KEY);
    localStorage.removeItem(TOKEN_KEY);
  }
  return;
};
