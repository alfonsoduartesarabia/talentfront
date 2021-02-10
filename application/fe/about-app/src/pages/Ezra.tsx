import styled from "styled-components";

export function AboutEzra() {
  return (
      <>
        <Background/>
        <Container>
          <Image/>
          <Title>Ezra Player</Title>
        </Container>
      </>
  );
};


const Background = styled.div`  
  background: rgb(250, 100, 97);
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

const avatarUrl = "https://avatars.githubusercontent.com/u/70980911?s=460&u=2bd30ac6cbde25af2d61e80572254b8b86e9316d&v=4"

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