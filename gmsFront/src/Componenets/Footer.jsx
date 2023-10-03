import "../Styles/Footer.css";
const Footer = () => {
  const date = new Date().getFullYear();
  return (
    <>
      <footer>
        <div className="p1">
          <p id="copy p1">
            Copyright © {date}. All rights reserved. Designed and Developed by
            NucleusTeq
          </p>
        </div>

        <div className="p2">
          <p id="p2">
            <b>Support :gms[at]nucleus[dot]com</b>
          </p>
        </div>
      </footer>
    </>
  );
};

export default Footer;
