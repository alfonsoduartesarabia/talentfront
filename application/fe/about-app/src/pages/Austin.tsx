import styled from "styled-components";

export function Austin() {
  return (
      <>
        <Background/>
        <Container>
          <Image/>
          <Title>Austin Wimberley</Title>
        </Container>
      </>
  );
};


const Background = styled.div`  
  background: rgb(108, 192, 97);
  position: absolute;
  min-height: 50.0rem;
  width: 100%;
`;

const Title = styled.div`
  color: rgb(34, 34, 34);
  padding-top: 40px;
  font-size: 4rem;
  font-weight: normal;
  text-align: center;
  letter-spacing: 0px;
  line-height: 49px;
`;

const avatarUrl = "https://avatars.githubusercontent.com/u/46357909?s=460&u=daa1ac695ee4eeb86c31b4d853dd9a04db7d49a0&v=4"

const Image = styled.img.attrs({
  src: `${avatarUrl}`
})`
  width: 300px;
  padding-top: 10px;
  padding-left: 10px;
`;

const Container = styled.section`
  position: relative;
  margin: 10 auto;

  padding-top: 1px;
`;
